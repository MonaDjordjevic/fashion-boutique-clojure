(ns fashionboutique.routes.clothingitem
    (:require
      [compojure.core :refer :all]
      [fashionboutique.layout :as layout]
      [clojure.java.io :as io]
      [ring.util.http-response :as response]
      [compojure.core :refer :all]
      [struct.core :as st]
      [ring.util.response :refer [redirect]]
      [selmer.parser :refer [render-file]]
      [fashionboutique.middleware.controller :as controller]
      [compojure.response :refer [render]]
      [buddy.auth :refer [authenticated?]]
      [liberator.core :refer [defresource]]
      [clojure.data.json :as json]
      [clojure.java.io :as io]
      [liberator.representation :refer [ring-response as-response]]
      [clojure.set :refer [rename-keys]]
      [clojure.string :as str]))
    
    (def clothingitem-schema
      {:itemdescription [st/required st/string]
       :price [st/required st/number]
       :brand [st/required st/number]})   

    (defn clothingitem-valid? [params]
      (st/valid? {:itemdescription (:itemdescription params)
                  :price (:price params)
                  :brand (:brand params)
   } clothingitem-schema))  
    
    
    (defn get-all-clothingitems [session]
      (render-file "items.html" {:clothingitems (controller/get-all-clothingitems)
                                      :admin (layout/is-admin? session)}))
    
    (defn edit-clothingitem [{:keys [params session]}]
      :allowed-methods [:put]
      :available-media-types ["application/json"]
      (controller/update-clothingitem params))

    (defn delete-clothingitem [{:keys [params session]}]
        (controller/delete-clothingitem (:id params)))
    
    (defroutes clothingitem-routes
      (GET "/clothingitems" clothingitem (get-all-clothingitems (:session clothingitem)))
      (PUT "/clothingitem" clothingitem (edit-clothingitem clothingitem))
      (DELETE "/clothingitem" clothingitem (delete-clothingitem clothingitem)))