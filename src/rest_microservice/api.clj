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

(defn next-id
  "Gets next available id for creating a user"
  []
  (+ 1 (:id (apply max-key :id @users))))

(defn create-user
  "Add a new user to the store"
  [username]
  (swap! users conj {:username username, :id (next-id)})
  (-> (format "Created user \"%s\"" username))
  )

(defn update-user
  "Updates specific user in the store"
  [id user]
  (-> "Not yet implemented")
  )

(defn get-user-by-id
  "Finds specific user in the store"
  [id]
  (-> (first (filter #(= (:id %) (Integer/parseInt id)) @users)))
  )

(defn delete-user
  "Removes user from the store"
  [id]
  (swap! users #(remove (fn [user] (= (:id user) (Integer/parseInt id))) %))
  (-> (format "Deleted user %s" id))
  )
