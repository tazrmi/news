(ns reprezentacija.views.views
   (:use [hiccup.core :as core]
         [hiccup.form :as form]
         [hiccup.page :as page]
         [model.news :as model]
         )
   (:require [clostache.parser :as clostache]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
    (str template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))



(defn welcome []
  (render-template "index" {:newest (model/newest)
                            :popular (model/topNews)})
 )

(defn news []
  (render-template "news" {:news (model/newsGenre)
                           :popular (model/topNews)})
  )

(defn sports []
  (render-template "sports" {:news (model/sportsGenre)
                             :popular (model/topNews)})
  )


(defn showbizz []
  (render-template "showbizz" {:news (model/showbizzGenre)
                               :popular (model/topNews)})
 )

(defn byId [id]
  (render-template "id" {:news (model/getById id)
                           :popular (model/topNews)
                           :similar (model/getSimilarTexts id)}))

