(ns rest-microservice.api
  (:gen-class))

(defonce store (atom [
                      {:username "admin"
                       :id       1}]))

(defn get-all-users
  "Return a list of all users in the store"
  []
  (-> @store)
  )



