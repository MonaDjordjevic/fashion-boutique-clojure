(ns fashionboutique.middleware.controller
  (:require [clojure.java.jdbc :as sql]
            [korma.core :as k]
            [korma.db :refer [defdb mysql]]
            [clj-time.coerce :as c]
            [clj-time.core :as t])
  (:import java.sql.DriverManager))

(def db-config(clojure.edn/read-string (slurp "configuration/migratus-conf.edn")))

(defdb db (mysql db-config))

(k/defentity user
             (k/table :user))

(defn find-user [params]
  (k/select user
            (k/where params)))

(defn get-user-by-email [params]
  (k/select user
            (k/where params)))

(k/defentity order
             (k/table :itemorder))

(defn add-order [params]
  (k/insert order
            (k/values params)))


(defn delete-order [id]
  (k/delete order
            (k/where {:id id})))

(defn find-order [params]
  (k/select order
            (k/where params)))

(defn update-order [params]
  (k/update order
            (k/set-fields params)
            (k/where {:id (:id params)})))

(k/defentity itemgroup
             (k/table :itemgroup))

(defn get-all-itemgroups []
  (k/select itemgroup))

(k/defentity clothingitem
             (k/table :clothingitem))

(defn update-clothingitem [params]
  (k/update clothingitem
            (k/set-fields params)
            (k/where {:itemid (:itemid params)})))

(defn delete-clothingitem [id]
  (k/delete clothingitem
            (k/where {:itemid id})))

 (defn get-all-orders [userId]
  (k/select order
    (k/fields :* [:clothingitem.itemdescription :clothingitem])
    (k/join clothingitem (= :itemorder.clothingitemId :clothingitem.itemid))
    (k/where {:userId userId})))

(defn get-all-clothingitems[]
  (k/select clothingitem))





