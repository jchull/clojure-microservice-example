(ns rest-microservice.handler
  (:use compojure.core
        ring.middleware.json)
  (:require [compojure.handler :as handler]
            [ring.util.response :refer [response]]
            [compojure.route :as route]
            [rest-microservice.routes :as app-routes]))

(defroutes app-routes
           (GET "/" [] "Nothing here")
           (context "/api" []
             (GET "/user" [] app-routes/get-all-users))
           (route/not-found "Not Found"))

(defn wrap-log-request [handler]
  (fn [req]
    (println req)
    (handler req)))

(def app
  (-> app-routes
      wrap-log-request
      wrap-json-response
      wrap-json-body))
