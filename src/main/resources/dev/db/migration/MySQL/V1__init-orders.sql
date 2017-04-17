create table account
(
  id bigint not null auto_increment
    primary key,
  password varchar(255) null,
  username varchar(255) null
)
;

create table address
(
  address_id bigint not null auto_increment
    primary key,
  city varchar(255) null,
  country varchar(255) null,
  street varchar(255) null,
  customer_id bigint null
)
;

create index FK93c3js0e22ll1xlu21nvrhqgg
  on address (customer_id)
;

create table customer
(
  customer_id bigint not null auto_increment
    primary key,
  email varchar(255) null,
  first_name varchar(50) null,
  last_name varchar(50) not null
)
;

alter table address
  add constraint FK93c3js0e22ll1xlu21nvrhqgg
foreign key (customer_id) references toregardDB.customer (customer_id)
;

create table cvping_log
(
  id bigint not null auto_increment
    primary key,
  date_time datetime null,
  text varchar(255) null
)
;

create table invoice
(
  invoice_id bigint not null auto_increment
    primary key,
  amount_due double null,
  date_cancelled datetime null,
  date_raised datetime null,
  date_settled datetime null,
  last_updated_time datetime null,
  order_id bigint not null,
  constraint UK_gnfabg6rvhoc3c9o4deqb1hn4
  unique (order_id)
)
;

create table lineitem
(
  cust_id bigint not null auto_increment
    primary key,
  amount int not null,
  price decimal(19,2) not null,
  product_product_id bigint null,
  order_id bigint null
)
;

create index FKccypecmkmnegu96vrh77agmij
  on lineitem (order_id)
;

create index FKmx9gf6c9ndwcyxhnu42c4thch
  on lineitem (product_product_id)
;

create table orders
(
  order_id bigint not null auto_increment
    primary key,
  customer_customer_id bigint not null,
  shipping_address_address_id bigint not null,
  constraint FKgk0a4775o5scnc1sjrg2w8afa
  foreign key (customer_customer_id) references toregardDB.customer (customer_id),
  constraint FKaaw2kt7w6wvp183f1to1qw2ms
  foreign key (shipping_address_address_id) references toregardDB.address (address_id)
)
;

create index FKaaw2kt7w6wvp183f1to1qw2ms
  on orders (shipping_address_address_id)
;

create index FKgk0a4775o5scnc1sjrg2w8afa
  on orders (customer_customer_id)
;

alter table invoice
  add constraint FKthf5w8xuexpjinfl7xheakhqn
foreign key (order_id) references toregardDB.orders (order_id)
;

alter table lineitem
  add constraint FKccypecmkmnegu96vrh77agmij
foreign key (order_id) references toregardDB.orders (order_id)
;

create table product
(
  product_id bigint not null auto_increment
    primary key,
  prod_desc varchar(200) null,
  prod_name varchar(50) not null,
  regular_price double not null,
  last_updated_time datetime null
)
;

INSERT INTO product ( REGULAR_PRICE,PROD_NAME, PROD_DESC, LAST_UPDATED_TIME) VALUES( 300,'ProductB3','pnavn3',CURRENT_TIMESTAMP());
INSERT INTO product ( REGULAR_PRICE,PROD_NAME, PROD_DESC,LAST_UPDATED_TIME) VALUES( 400,'ProductB4','pnavn4',CURRENT_TIMESTAMP());
INSERT INTO product ( REGULAR_PRICE,PROD_NAME, PROD_DESC,LAST_UPDATED_TIME) VALUES(500,'ProductB5','pnavn5',CURRENT_TIMESTAMP());

alter table lineitem
  add constraint FKmx9gf6c9ndwcyxhnu42c4thch
foreign key (product_product_id) references toregardDB.product (product_id)
;

create table product_attributes
(
  product_product_id bigint not null,
  attributes varchar(255) null,
  attributes_key varchar(255) not null,
  primary key (product_product_id, attributes_key),
  constraint FKcos1hpnm9gebk4gtpatnma2kd
  foreign key (product_product_id) references toregardDB.product (product_id)
)
;

create table role
(
  id bigint not null auto_increment
    primary key,
  role varchar(255) null
)
;

create table routes
(
  id bigint not null auto_increment
    primary key,
  agency_id varchar(255) null,
  route_color varchar(255) null,
  route_desc varchar(255) null,
  route_id varchar(255) null,
  route_long_name varchar(255) null,
  route_short_name varchar(255) null,
  route_text_color varchar(255) null,
  route_type varchar(255) null,
  route_url varchar(255) null
)
;

