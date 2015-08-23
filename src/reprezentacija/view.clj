(ns reprezentacija.view
  (:use compojure.core, ring.adapter.jetty)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [reprezentacija.views.views :as views]
            ))


(defroutes main-routes
  (GET "/" [] (views/welcome))
   (route/resources "/") 
   (GET "/news" [] (views/news))
   (GET "/sports" [] (views/sports))
   (GET "/showbizz" [] (views/showbizz))
   (GET "/byId/:id" [id] (views/byId id))
   
  (route/not-found "404 Not Found"))

(def routes2 (handler/api main-routes))

(run-jetty routes2 {:port 8088})