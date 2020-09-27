(ns rest-microservice.routes
  (:require
    [rest-microservice.api :as api]
    [ring.util.request :as req])
  (:gen-class))

(defn get-all-users
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (-> (api/get-all-users))})

(defn create-user
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (-> (api/create-user (get-in req [:body "username"])))})

(defn get-user-by-id
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (-> (api/get-user-by-id (re-find #"\d+" (get req :path-info))))})

(defn update-user
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (-> (api/update-user (get-in req [:body])))})

(defn delete-user
  [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (-> (api/delete-user (re-find #"\d+" (get req :path-info))))})
