(ns rest-microservice.handler
  (:use compojure.core
        ring.middleware.json
        ring.middleware.params)
  (:require [ring.util.response :refer [response]]
            [compojure.route :as route]
            [rest-microservice.routes :as app-routes]))

(defroutes app-routes
           (GET "/" [] "Nothing here")
           (context "/api" []
             (GET "/user" []app-routes/get-all-users)
             (POST "/user" [] app-routes/create-user)
             (GET "/user/:id" [] app-routes/get-user-by-id)
             (PUT "/user/:id" [] app-routes/update-user)
             (DELETE "/user/:id" [] app-routes/delete-user))
           (route/not-found "Not Found"))

(defn wrap-log-request [handler]
  (fn [req]
    (println req)
    (handler req)))

(def app
  (-> app-routes
      wrap-log-request
      wrap-json-response
      wrap-json-body
      ))
