(ns view.view
  (:use compojure.core, ring.adapter.jetty)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [controler.controler :as controler]))


(defroutes main-routes
  (GET "/" [] (controler/welcome))
    (route/resources "/") 
  (GET "/:genre" [genre] (controler/page genre))
  (GET "/byId/:id" [id] (controler/by-id id))
  (route/not-found "404 Not Found"))

(def routes2 (handler/api main-routes))

(run-jetty routes2 {:port 8088})