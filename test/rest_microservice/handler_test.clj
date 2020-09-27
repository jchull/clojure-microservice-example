(ns rest-microservice.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [rest-microservice.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Nothing here"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404))))

  (testing "get all users"
    (let [response (app (mock/request :get "/api/user"))]
      (is (= (:status response) 200))
      (is (= (:body response) "[{\"username\":\"admin\",\"id\":1}]"))))

  ;(testing "get user by name"
  ;  (let [response (app (mock/request :get "/api/user?username=admin"))]
  ;    (is (= (:status response) 200))
  ;    (is (= (:body response) "{\"username\":\"admin\",\"id\":1}"))))

  (testing "get user by id"
    (let [response (app (mock/request :get "/api/user/1"))]
      (is (= (:status response) 200))
      (is (= (:body response) "{\"username\":\"admin\",\"id\":1}"))))

  (testing "create user"
    (let [response (app (mock/json-body
                          (mock/request :post "/api/user")
                          {:username "jimbo"}))]
      (is (= (:status response) 200))
      (is (= (:body response) "Created user \"jimbo\""))))

  (testing "delete user"
    (let [response (app (mock/request :delete "/api/user/1"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Deleted user 1")))))

