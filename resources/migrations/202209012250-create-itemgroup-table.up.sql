CREATE TABLE itemgroup(
  itemgroupid int(11) NOT NULL AUTO_INCREMENT,
  groupname varchar(50) NOT NULL,
  season varchar(50) NOT NULL,
  PRIMARY KEY (itemgroupid)
);
insert  into itemgroup(itemgroupid, groupname, season) values
(1,'Tops','All seasons'),
(2,'Dress/Skirt','Spring/Summer'),
(3,'Bottoms','All seasons'),
(4,'Jacket','Winter');
