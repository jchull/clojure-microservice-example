(defproject rest-microservice "0.1.0-SNAPSHOT"
  :description "Example REST API using clojure"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/data.json "0.2.6"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-devel "1.6.3"]
                 [ring/ring-json "0.5.0"]
                 [compojure "1.6.1"]
                 [http-kit "2.3.0"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler rest-microservice.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
