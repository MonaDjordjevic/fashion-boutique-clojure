CREATE TABLE clothingitem(
  itemid int(11) NOT NULL AUTO_INCREMENT,
  itemdescription varchar(50) NOT NULL,
  price int NOT NULL,
  brand varchar(50) NOT NULL,
  itemgroupid int(11) NOT NULL,
  PRIMARY KEY (itemid),
  FOREIGN KEY(itemgroupid) REFERENCES itemgroup(itemgroupid) ON UPDATE CASCADE ON DELETE CASCADE
);

insert into clothingitem(itemid,itemdescription,price,brand,itemgroupid) values
(1,'Floral dress',5000,"Zara",1),
(2,'Black trousers',2500,"Zara",3),
(3,'Pleated skirt',3000,"Zara",2),
(4,'Printed T-shirt',3000,"Zara",1),
(5,'Linen bermuda shorts',3000,"Zara",3),
(6,'Ruffled blouse',3000,"Zara",1)




