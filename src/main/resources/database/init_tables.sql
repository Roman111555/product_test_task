create table currency (
id int8 not null,
country varchar(255),
currency varchar(255),
code varchar(255),
symbol varchar(255),
primary key (id));

create table languages (
id int8 not null,
language_name varchar(255),
language_mark varchar(255),
primary key (id));

create table products (
id int8 not null,
create_date varchar(255),
description varchar(255),
price float8,
product_name varchar(255) not null,
update_date varchar(255),
currency_id int8,
lang_id int8, primary key (id));

alter table if exists products add constraint FK5x3an021g49vrd2e4g1231323 foreign key (currency_id) references currency;
alter table if exists products add constraint FKn0dhwugodp5lfsbxid1231231 foreign key (lang_id) references languages;