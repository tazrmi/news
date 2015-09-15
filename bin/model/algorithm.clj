(ns model.algorithm
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]
            [clojure.string :as cs]
            [model.data :as data]))

(def db-spec {:classname "org.h2.Driver"
              :subprotocol "h2:file"
              :subname "db/my-webapp"})

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
                                ["select * from news where id=?" id]
                                  :row-fn data/replace-clob) 0))))

(defn numerator 
  [row id]
  "The numerator for the Sorensen-Dice index."
  (* 2.0 (count (intersect (letter-pairs 
                             (clojure.string/replace 
                               (clojure.string/trim (:text (data/replace-clob row))) #"\s" ""))
                (get-selected-text id)))))

(defn denominator 
  [row id]
  "The dominator for the Sorensen-Dice index."
  (+ (count (letter-pairs 
              (clojure.string/replace (clojure.string/trim
                                        (:text (data/replace-clob row))) #"\s" ""))) 
            (count (get-selected-text id))))

(defn text-difference
 [row id]
 "Fills the list with values."
 (assoc row :difference (/ (numerator row id) (denominator row id))))

(defn get-similar-texts
  [id]
  "Returns three most similar news to the one selected."
  (take 3 (rest (reverse 
                  (sort-by :difference (j/query db-spec
                    ["select * from news"]
                      :row-fn #(text-difference % id))))))) 