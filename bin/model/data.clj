(ns model.data
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]
            [clojure.string :as cs]))

(def db-spec {:classname "org.h2.Driver"
              :subprotocol "h2:file"
              :subname "db/my-webapp"})

(defn clob-to-string
  [clob]
  (with-open [rdr (java.io.BufferedReader. (.getCharacterStream clob))]
    (apply str (line-seq rdr))))

(defn replace-clob 
  [row]
  "Changes clob to string."
  (assoc row :part (clob-to-string (:part row))
             :text (clob-to-string (:text row))))

(defn newest 
[]
"Selects the 10 most recent news from the database."
  (j/query db-spec
    ["select * from news order by date desc limit 10"]
      :row-fn replace-clob))

(defn top-news 
  []
  "Selects 6 most read news from the database."
  (j/query db-spec ["select id, title from news order by timesRead desc limit 6"]))

(defn top-genre 
  [genre]
  "Selects the 10 most recent news of a certain genre from the database."
  (j/query db-spec
    ["select * from news where genre=? order by date desc limit 10" genre]
      :row-fn replace-clob))

(defn get-times-read 
  [id]
  "Gets the number of times a specific news was read from the database."
  (:timesread (nth (j/query db-spec ["select * from news where id=?" id]) 0)))

(defn update-times-read 
  [id]
  "Increases the number of times a news was read by one."
  (j/update! db-spec :news
    {:timesRead (inc (get-times-read id))} ["id = ?" id]))

(defn by-id
  [id]
  "Selects a specific news from the database."
  (update-times-read id)
  (j/query db-spec
    ["select * from news where id=?" id]
      :row-fn replace-clob))