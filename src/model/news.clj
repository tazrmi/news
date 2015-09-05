(ns model.news
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]
            [clojure.string :as cs]))

(def db-spec {:classname "org.h2.Driver"
              :subprotocol "h2:file"
              :subname "db/my-webapp"})

(def difference-list (list {:id 0 :title "Just a title" :difference 0.0}))

(defn set-difference-list 
  []
  "Erases the list before the new inserts."
  (def difference-list (list {:id 0 :title "Just a title" :difference 0.0})))

(defn intersect 
  [s1 s2]
  "Returns a colecton of elements that exist in both of the parameters."
  (let [f1 (frequencies s1)
        f2 (frequencies s2)
        d1 (apply dissoc f1 (keys f2))
        d2 (apply dissoc f2 (keys f1))
        f1 (apply dissoc f1 (keys d1))
        f2 (apply dissoc f2 (keys d2))]
    (mapcat
      (fn [[k v]]
        (repeat v k))
      (merge-with min f1 f2))))

(defn clob-to-string-part 
  [row]
  "Changes clob to string."
  (assoc row :part (with-open [rdr (java.io.BufferedReader. (.getCharacterStream (:part row)))]
    (apply str (line-seq rdr)))))

(defn clob-to-string-text
  [row]
  "Changes clob to string."
  (assoc row :text (with-open [rdr (java.io.BufferedReader. (.getCharacterStream (:text row)))]
    (apply str (line-seq rdr)))))

(defn newest 
  []
  "Selects the 10 most recent news from the database."
  (j/query db-spec
    ["select id, title, part from news order by date desc limit 10"]
      :row-fn clob-to-string-part))

(defn top-news 
  []
  "Selects 6 most read news from the database."
  (j/query db-spec ["select id, title from news order by timesRead desc limit 6"]))

(defn news-genre 
  []
  "Selects the 10 most recent world news from the database."
  (j/query db-spec
    ["select id, title, part from news where genre=? order by date desc limit 10" "worldNews"]
      :row-fn clob-to-string-part))

(defn sports-genre 
  []
  "Selects the ten most recent sports news from the database."
  (j/query db-spec
    ["select id, title, part from news where genre=? order by date desc limit 10" "sports"]
      :row-fn clob-to-string-part))

(defn showbizz-genre 
  []
  "Selects the ten most recent showbizz news from the database."
  (j/query db-spec
    ["select id, title, part from news where genre=? order by date desc limit 10" "showbizz"]
      :row-fn clob-to-string-part))

(defn get-times-read 
  [id]
  "Gets the number of times a specific news was read from the database."
  (:timesread (nth (j/query db-spec ["select * from news where id=?" id]) 0)))

(defn update-times-read 
  [id]
  "Increases the number of times a news was read by one."
  (j/update! db-spec :news
    {:timesRead (inc (get-times-read id))} ["id = ?" id]))

(defn letter-pairs 
  [joined]
  "Makes a colection of letter pairs in a text."
  (mapv clojure.string/join 
    (butlast (partition-all 2 1 
               (subvec (clojure.string/split joined #"")1)))))

(defn join-selected-text 
  [words]
  "Takes the text and joins the words and returns the letter pairs."
  (letter-pairs (clojure.string/replace (clojure.string/trim words) #"\s" "")))

(defn get-selected-text 
  [id]
  "Gets the text of the selected news from the database."
  (join-selected-text (:text (nth (j/query db-spec
                                ["select text from news where id=?" id]
                                  :row-fn clob-to-string-text) 0))))

(defn get-by-id 
  [id]
  "Empties the list, updates the times a news was read and gets the selected news from the database."
  (set-difference-list)
  (update-times-read id)
  (j/query db-spec
    ["select * from news where id=?" id]
      :row-fn clob-to-string-text))

(defn numerator 
  [row id]
  "The numerator for the Sorensen-Dice index."
  (* 2.0 (count (intersect (letter-pairs 
                             (clojure.string/replace 
                               (clojure.string/trim (:text (clob-to-string-text row))) #"\s" ""))
                (get-selected-text id)))))

(defn denominator 
  [row id]
  "The dominator for the Sorensen-Dice index."
  (+ (count (letter-pairs 
              (clojure.string/replace (clojure.string/trim
                                        (:text (clob-to-string-text row))) #"\s" ""))) 
            (count (get-selected-text id))))

(defn text-difference
 [row id]
 "Fills the list with values."
 (def difference-list 
   (conj difference-list {:id (:id row) :title (:title row) :difference (/ (numerator row id) (denominator row id))})))

(defn get-similar-texts
  [id]
  "Returns three most similar news to the one selected."
  (j/query db-spec
    ["select id, title, text from news"]
    :row-fn #(text-difference % id))
  (take 3 (rest(reverse(sort-by :difference difference-list)))))