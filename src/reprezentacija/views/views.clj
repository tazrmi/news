(ns reprezentacija.views.views
   (:use [hiccup.core :as core]
         [hiccup.form :as form]
         [hiccup.page :as page]
         [model.news :as model])
   (:require [clostache.parser :as clostache]))

(defn read-template 
  [template-name]
  (slurp (clojure.java.io/resource
    (str template-name ".mustache"))))

(defn render-template 
  [template-file params]
  (clostache/render (read-template template-file) params))

(defn welcome 
  []
  "Shows the index page."
  (render-template "index" {:news (model/newest)
                            :popular (model/top-news)}))

(defn news 
  []
  "Shows the page with news around the world."
  (render-template "news" {:news (model/news-genre)
                        :popular (model/top-news)}))

(defn sports
  []
  "Shows the page with sports news."
  (render-template "sports" {:news (model/sports-genre)
                             :popular (model/top-news)}))

(defn showbizz 
  []
  "Shows the page with showbizz news."
  (render-template "showbizz" {:news (model/showbizz-genre)
                               :popular (model/top-news)}))

(defn by-id 
  [id]
  "Shows the specific news page."
  (render-template "id" {:news (model/get-by-id id)
                         :popular (model/top-news)
                     :similar (model/get-similar-texts id)}))