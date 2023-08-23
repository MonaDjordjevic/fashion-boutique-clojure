CREATE TABLE user(
  userid int(11) NOT NULL AUTO_INCREMENT,
  firstname varchar(50) NOT NULL,
  lastname varchar(50) NOT NULL,
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  assignedrole varchar(10) NOT NULL,
  PRIMARY KEY (userid)
);


insert into user(userid,firstname,lastname,username,password,email,assignedrole) values
(1,'Mona','Djordjevic','mona','m123','djordjevic.mona@gmail.com','admin'),
(2,'Ognjen','Djordjevic','ogi','o123','djordjevic.ognjen@gmail.com','user'),
(3,'Dejan','Djordjevic','dejan','d123','djordjevic.dejan@gmail.com','user');

