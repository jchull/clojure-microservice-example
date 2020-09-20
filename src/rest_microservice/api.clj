(ns rest-microservice.api
  (:gen-class))

(defonce users (atom [
                      {:username "admin"
                       :id       1}]))

(defn get-all-users
  "Return a list of all users in the store"
  []
  (-> @users)
  )



