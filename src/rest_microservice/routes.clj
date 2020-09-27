(ns rest-microservice.routes
  (:require
    [rest-microservice.api :as api])
  (:gen-class))

(defn get-all-users
  []
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (-> (api/get-all-users))})

(defn create-user
  [username]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (-> (api/create-user username))})

(defn get-user-by-id
  [id]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (-> (api/get-user-by-id id))})

(defn update-user
  [id body]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (-> (api/update-user id body))})

(defn delete-user
  [id]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (-> (api/delete-user id))})
