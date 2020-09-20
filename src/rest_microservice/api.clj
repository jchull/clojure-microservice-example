(ns rest-microservice.api
  (:require
    [rest-microservice.data :as data])
  (:gen-class))


(defn get-all-users
  "Return a list of all users in the store"
  []
  (-> (data/get-store))
  )



