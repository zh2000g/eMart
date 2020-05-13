#create database emartdb;
#use emartdb;
#source C:/zhaogang/work/2020/_2020fsd/milestone3/db_create.sql

create table seller (
  id INT(8) not null auto_increment,
  user_id VARCHAR(30) not null,
  user_name VARCHAR(50) not null,
  password VARCHAR(20) not null,
  company_name VARCHAR(50),
  brief_of_company VARCHAR(100),
  gstin VARCHAR(20),
  post_address VARCHAR(50),
  website VARCHAR(100),
  email VARCHAR(50),
  contract_number VARCHAR(50),
  primary key(id)
);

create table category (
  id INT(8) not null auto_increment,
  category_name VARCHAR(50) not null,
  brief_details VARCHAR(50),
  parent_category_id INT(8),
  primary key(id)
);

create table buyer (
  id INT(8) not null auto_increment,
  user_id VARCHAR(30) not null,
  user_name VARCHAR(50) not null,
  password VARCHAR(20) not null,
  email VARCHAR(50),
  mobile_number VARCHAR(50),
  primary key(id)
);

create table item (
  id INT(8) not null auto_increment,
  item_name VARCHAR(50) not null,
  category_id INT(8),
  sub_category_id INT(8),
  seller VARCHAR(30) not null,
  price DOUBLE  not null,
  remain_num INT(8) not null,
  image_url_1 VARCHAR(255),
  image_url_2 VARCHAR(255),
  image_url_3 VARCHAR(255),
  image_url_4 VARCHAR(255),
  primary key(id)
);


create table deal (
  id INT(8) not null auto_increment,
  item_id INT(8) not null,
  item_name VARCHAR(50) not null,
  category_id INT(8),
  sub_category_id INT(8),
  seller VARCHAR(30) not null,
  buyer VARCHAR(30) not null,
  price DOUBLE  not null,
  purchase_num INT(8) not null,
  purchase_time DATETIME,
  primary key(id)
);

create table cart (
  id INT(8) not null auto_increment,
  item_id INT(8) not null,
  item_name VARCHAR(50) not null,
  category_id INT(8),
  sub_category_id INT(8),
  seller VARCHAR(30) not null,
  buyer VARCHAR(30) not null,
  price DOUBLE  not null,
  add_num INT(8) not null,
  add_time DATETIME,
  primary key(id)
);

insert into category values (1,"Computer","Computer Category",0);
insert into category values (2,"Books","Books Category",0);
insert into category values (3,"Cloths","Cloths Category",0);
insert into category values (4,"Note PC","Note PC SubCategory",1);
insert into category values (5,"Tablelet","Tablelet SubCategory",1);
insert into category values (6,"Pocket PC","Pocket PC SubCategory",1);
insert into category values (7,"Noval","Noval SubCategory",2);


insert into seller values (1,"seller1","First seller","12345","Test Company",
               "Company Brief","123456","New York","http://www.test.com","test@test.com","1234567");

insert into buyer values (1,"buyer1","First buyer","12345","test@test.com","1234567");

