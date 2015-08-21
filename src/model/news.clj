(ns model.news
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]
            [clojure.string :as cs]
          ))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/clojure"
               :user "root"
               :pass ""
              })

(def differenceList (list {:id 0 :title "Just a title" :difference 0.0}))



(defn setDifferenceList []
  (def differenceList (list {:id 0 :title "Just a title" :difference 0.0}))
  )

(defn newest []
  (j/query mysql-db
    ["select * from news order by date desc limit 10"])
 )

(defn mostPopular []
  (j/query mysql-db
    ["select * from news order by timesRead desc limit 5"]))

(defn newsGenre []
  (j/query mysql-db
    ["select * from news where genre=? order by date desc limit 10" "worldNews"]))

(defn sportsGenre []
  (j/query mysql-db
    ["select * from news where genre=? order by date desc limit 10" "sports"]))

(defn showbizzGenre []
  (j/query mysql-db
    ["select * from news where genre=? order by date desc limit 10" "showbizz"]))

(defn getTimesRead [id]
  (:timesread (nth (j/query mysql-db ["select * from news where id=?" id]) 0)))

(defn updateTimesRead [id]
  (getTimesRead id)
  (j/update! mysql-db :news
           {:timesRead (+ 1 (getTimesRead id))}
           ["id = ?" id])
)

(defn getById [id]
   (updateTimesRead id)
  (j/query mysql-db
    ["select * from news where id=?" id]
  ))

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

(defn letterPairs [onewordtext]
(mapv clojure.string/join (butlast (partition-all 2 1 (subvec (clojure.string/split onewordtext #"")1)))))

(defn oneWordT [words]
  (letterPairs (clojure.string/replace (clojure.string/trim words) #"\s" "")))

(defn printOneRowText [row]
       (oneWordT (row :text)) 
  ) 

(defn getSelectedText [id]
  (oneWordT (:text (nth (j/query mysql-db
    ["select text from news where id=?" id]
     )
     0)
    )))

(defn oneWord [rowText rowId rowTitle selectedRowId]
   (def differenceList (conj differenceList {:id rowId :title rowTitle :difference (/ (* 2.0 (count (intersect (letterPairs (clojure.string/replace (clojure.string/trim rowText) #"\s" ""))(getSelectedText selectedRowId)))) (+ (count (letterPairs (clojure.string/replace (clojure.string/trim rowText) #"\s" ""))) (count (getSelectedText selectedRowId))))})))

   




(defn printText[row id]
  
(oneWord (row :text) (row :id) (row :title) id ))
 
(defn getSimilarTexts[id]
   
  (j/query mysql-db
    ["select * from news"]
    :row-fn #(printText % id)
  )
  (take 3 (rest (reverse(sort-by :difference differenceList)))))





