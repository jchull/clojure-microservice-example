(ns rest-microservice.handler
  (:use compojure.core
        ring.middleware.json
        ring.middleware.params)
  (:require [ring.util.response :refer [response]]
            [compojure.route :as route]
            [rest-microservice.routes :as app-routes]))

(defroutes app-routes
  (GET "/" [] "Nothing here")
  (context "/api" [] (defroutes api-routes
    (context "/user" [] (defroutes user-routes
      (GET "/" [] (app-routes/get-all-users))
      (POST "/" {body :body} (app-routes/create-user (body "username")))
      (context "/:id" [id] (defroutes user-id-routes
        (GET "/" [] (app-routes/get-user-by-id id))
        (PUT "/" {body :body} (app-routes/update-user id body))
        (DELETE "/" [] (app-routes/delete-user id))
      ))
    ))
  ))
 (route/not-found "Not Found")
)


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
