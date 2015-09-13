(ns controler.controler
   (:use [hiccup.core :as core]
         [hiccup.form :as form]
         [hiccup.page :as page])
   (:require [clostache.parser :as clostache]
             [model.data :as model]
             [model.algorithm :as algoritm]))

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

(defn page 
  [genre]
  "Shows the page with news of a specific genre."
  (render-template "page" {:news (model/top-genre genre)
                           :popular (model/top-news)}))

(defn by-id 
  [id]
  "Shows the specific news page."
  (render-template "id" {:news (model/by-id id)
                         :popular (model/top-news)
                         :similar (algoritm/get-similar-texts id)}))