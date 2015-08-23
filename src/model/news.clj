(ns model.news
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]
            [clojure.string :as cs]
            [model.fillDatabase :as database]
          ))

(def db-spec {:classname "org.h2.Driver"
              :subprotocol "h2:file"
              :subname "db/my-webapp"})

(def differenceList (list {:id 0 :title "Just a title" :difference 0.0}))



(defn setDifferenceList []
  (def differenceList (list {:id 0 :title "Just a title" :difference 0.0}))
  )

(defn intersect [s1 s2]
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

(defn clob-to-string [row]
  (assoc row :part (with-open [rdr (java.io.BufferedReader. (.getCharacterStream (:part row)))]
    (apply str (line-seq rdr)))))

(defn clob-to-string-text [row]
  (assoc row :text (with-open [rdr (java.io.BufferedReader. (.getCharacterStream (:text row)))]
    (apply str (line-seq rdr)))))

(defn newest []
 (database/mysql-db)
 (setDifferenceList)
 (j/query db-spec
          ["select id, title, part from news order by date desc limit 10"]
          :row-fn clob-to-string
    ))

(defn topNews []
 (j/query db-spec
          ["select id, title from news order by timesRead desc limit 6"]
          
    ))

(defn newsGenre []
  (setDifferenceList)
  (j/query db-spec
          ["select id, title, part from news where genre=? order by date desc limit 10" "worldNews"]
          :row-fn clob-to-string
    ))

(defn sportsGenre []
  (setDifferenceList)
  (j/query db-spec
          ["select id, title, part from news where genre=? order by date desc limit 10" "sports"]
          :row-fn clob-to-string
    ))

(defn showbizzGenre []
  (setDifferenceList)
  (j/query db-spec
          ["select id, title, part from news where genre=? order by date desc limit 10" "showbizz"]
          :row-fn clob-to-string
    ))

(defn getTimesRead [id]
 (:timesread (nth (j/query db-spec ["select * from news where id=?" id]) 0)))

(defn updateTimesRead [id]
  (j/update! db-spec :news
           {:timesRead (+ 1 (getTimesRead id))}
           ["id = ?" id])
)

(defn letterPairs [onewordtext]
(mapv clojure.string/join (butlast (partition-all 2 1 (subvec (clojure.string/split onewordtext #"")1)))))

(defn oneWordT [words]
  (letterPairs (clojure.string/replace (clojure.string/trim words) #"\s" "")))

(defn getSelectedText [id]
  (oneWordT (:text (nth (j/query db-spec
    ["select text from news where id=?" id]
          :row-fn clob-to-string-text
     )
     0)
    )))

(defn getById [id]
  (setDifferenceList)
  (j/query db-spec
    ["select * from news where id=?" id]
        :row-fn clob-to-string-text
  ))


(defn text-difference[row id]
 (def differenceList (conj differenceList {:id (:id row) :title (:title row) :difference (/ (* 2.0 (count (intersect (letterPairs (clojure.string/replace (clojure.string/trim 
(:text (clob-to-string-text row))) #"\s" ""))(getSelectedText id)))) (+ (count (letterPairs (clojure.string/replace (clojure.string/trim 
(:text (clob-to-string-text row))) #"\s" ""))) (count (getSelectedText id))))})))

(defn getSimilarTexts[id]
   
  (j/query db-spec
    ["select id, title, text from news"]
    :row-fn #(text-difference % id)
  )
  (take 3 (rest(reverse(sort-by :difference differenceList))))
  )



