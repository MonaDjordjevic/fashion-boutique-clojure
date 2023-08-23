CREATE TABLE itemorder(
  id int(11) NOT NULL AUTO_INCREMENT,
  size int(11) NOT NULL,
  quantity int(11) NOT NULL,
  orderdate date NOT NULL,
  shippingAddress varchar(50) NOT NULL,
  clothingitemId int(11) NOT NULL,
  userId int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(clothingitemId) REFERENCES clothingitem(itemid) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(userId) REFERENCES user(userid) ON UPDATE CASCADE ON DELETE CASCADE
);

insert into itemorder(id, size, quantity, orderdate, shippingAddress, clothingitemId, userId) values
(1,'S',3,'2022-11-12', 'test', 5, 1),
(2,'XS', 4,'2022-11-14', 'test', 6, 1);
