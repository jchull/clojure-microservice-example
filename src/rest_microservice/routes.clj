(ns rest-microservice.routes
  (:require
    [rest-microservice.api :as api])
  (:gen-class))

(defn get-all-users
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (-> (api/get-all-users))})

