drop table orders if exists;
drop table user if exists;

create TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(50) DEFAULT NULL,
  password varchar(50) DEFAULT NULL,
  name varchar(50) DEFAULT NULL,
  gender varchar(50) DEFAULT NULL,
  age int(11) DEFAULT NULL,
  PRIMARY KEY (id)
);


insert into user
values
(1,'admin','admin','John Doe','MALE', 28),
(2,'christian','christian','Christian Bale','MALE', 35),
(3,'hugh','hugh','Hugh Jackman','MALE', 45),
(4,'ross','ross','Ross Geller','MALE', 35),
(5,'chandler','chandler','Chandler Bing','MALE',35),
(6,'monica','monica','Monica Geller','FEMALE',34),
(7,'rachel','rachel','Rachel Greene','FEMALE',40),
(8,'pheobe','pheobe','Pheobe Buffay','FEMALE',40);


create TABLE orders (
  order_id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) DEFAULT NULL,
  no_of_items int(11) DEFAULT NULL,
  total_amount double DEFAULT NULL,
  order_date date DEFAULT NULL,
  PRIMARY KEY (order_id),
  foreign key (user_id) references user(id)
 );


insert into orders values (1,5,3,635,'2020-01-10'),(2,8,1,1045,'2020-10-13'),(3,5,5,1000,'2020-01-14');
