(ns businesspartners.routes.home
  (:require
   [businesspartners.layout :as layout]
   [clojure.java.io :as io]
   [businesspartners.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]
   [businesspartners.db.dbbroker :as db]))


(defn home-page [request]
  (layout/render request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [request]
  (layout/render request "about.html"))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/about" {:get about-page}]])

