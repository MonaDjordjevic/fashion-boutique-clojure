(ns fashionboutique.handler
  (:require [compojure.core :refer [defroutes routes]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [ring.middleware.session :refer [wrap-session]]
            [ring.middleware.params :refer [wrap-params]]
            [hiccup.middleware :refer [wrap-base-url]]
            [liberator.dev :refer :all]
            [selmer.parser :refer :all]
            [fashionboutique.routes.home :refer [home-routes]]
            [fashionboutique.routes.login :refer [login-routes]]
            [fashionboutique.routes.order :refer [order-routes]]
            [fashionboutique.routes.clothingitem :refer [clothingitem-routes]]
            [ring.middleware.webjars :refer [wrap-webjars]]
            [ring.middleware.flash :refer [wrap-flash]]
            [buddy.auth.backends.session :refer [session-backend]]
            [buddy.auth.middleware :refer [wrap-authentication wrap-authorization]]
            [buddy.auth.accessrules :refer [wrap-access-rules success error]]
            [buddy.auth :refer [authenticated?]]
            [buddy.auth.accessrules :refer [restrict]]
            [ring.middleware.json :refer [wrap-json-response]]))

(def backend (session-backend))

(defroutes app-routes
           (route/resources "/")
           (route/not-found "Not Found"))

(def app
  (-> (routes home-routes order-routes clothingitem-routes)
      (wrap-json-response)
      (handler/site)
      (wrap-authentication backend)
      (wrap-authorization backend)
      (wrap-base-url)
      (wrap-trace :header :ui)
      (wrap-resource "public")))
