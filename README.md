[FASHIONBOUTIQUE_DB_CONFIG]:configuration/db-config.edn
[FASHIONBOUTIQUE_MIGRATUS_CONF]:configuration/migratus-conf.edn

# Fashion boutique Clojure app

App is designed to simulate fashion boutique app. Users can easily create new orders for available clothing items. Admin users can also manage clothing items that are available for online shopping.

## Prerequisites
Leiningen 2.0+ and MySQL need to be installed to run this application.

## Relational Data Model
Below you can find relational data model used in fashionboutique database:

> * User(__userid__, firstname, lastname, username, password, email, assignedrole)
> * ItemGroup(__itemgroupid__, groupname, season)
> * ClothingItem(__itemid__, itemdescription, price, brand, *itemgroupid*)
> * ItemOrder(__id__, size, quantity, orderdate, shippingaddress, *clothingitemid*, *userid*)

## Installing
Before you run app, you need to create database and adequate tables. First you need to create fashionboutique database.
You will also need to change user and password values in [db-config][FASHIONBOUTIQUE_DB_CONFIG] and [migratus-conf][FASHIONBOUTIQUE_MIGRATUS_CONF] files.

After you have configured your database and previously mentioned settings navigate to your project directory and run the following command in terminal
```
lein migratus migrate
```
Now all tables are created in the fashionboutique database.
## Running
To start a web server for the application, run:
 > * lein ring server 

 App will be running on localhost:3000
## Libraries
Project was developed using the following libraries:
> * Leiningen: Leiningen is the easiest way to use Clojure. With a focus on project automation and declarative configuration, it gets out of your way and lets you focus on your code.
> * Compojure: A small routing library for Ring that allows web applications to be composed of small, independent parts. 
> * Ring: A Clojure web applications library inspired by Python's WSGI and Ruby's Rack. By abstracting the details of HTTP into a simple, unified API, Ring allows web applications to be constructed of modular components that can be shared among a variety of applications, web servers, and web frameworks.
> * Hiccup: A library for representing HTML in Clojure. It uses vectors to represent elements, and maps to represent an element's attributes.
> * Liberator: A Clojure library that helps you expose your data as resources while automatically complying with all the relevant requirements of the HTTP specification
> * Buddy: A complete security library for clojure with support for: authentication, authorization, access rules, secure has functions, password hashing algorithms (bcrypt, pbkdf2, scrypt), ...

All pages are developed using html, css, boostrap and jquery.

## Project description

Project simulates fashion boutique web app. Before user can manage any data in the app he need to login. User can either have admin or user role. If user is admin he can create new orders, update existing orders and update or delete clothing items. Non admin user can only create, update and delete his orders. 

User needs to enter his username and password in order to login. After successful login home page is opened, where some of the clothing items are displayed. On the home page user can navigate through pages using header links.

By clicking on New Order navigation link New Order page is opened. Here user can choose the clothing item from the dropdown list, choose size, quantity and shipping address. After clicking on order button new Order is created and orders page is previewed. 

Orders page shows all orders user has previously made. Here user can update and delete any order using update and delete button.

If user has admin role he can also navigate to Items page where he can see all items, update or delete them. When item is deleted all orders that include this product are also deleted.

When the user wants to exit the system, he can click on the Logout button.


## IDE
- For development purposes VSCode editor was used.
