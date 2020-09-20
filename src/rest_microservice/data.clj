(ns rest-microservice.data
  (:gen-class))

(defonce store (atom [
                      {:username "admin"
                       :id       1}]))

(defn get-store
  []
  (-> @store))
