


DROP TABLE IF EXISTS orders;
 
CREATE TABLE orders(order_id bigint not null AUTO_INCREMENT,customer_name varchar(20) not null,order_date varchar(50) not null,
shipping_address varchar(200) not null,order_tems varchar(20) not null,total varchar(20) not null,
                  CONSTRAINT order_id_pk PRIMARY KEY(order_id));
                  
DROP TABLE IF EXISTS items;

CREATE TABLE items(item_id bigint not null AUTO_INCREMENT,product_code varchar(20) not null,product_name varchar(20) not null,
quantity varchar(30) not null,price varchar(20) not null,order_id bigint not null,
CONSTRAINT item_id_pk PRIMARY KEY(item_id),CONSTRAINT order_id_fk FOREIGN KEY(order_id) REFERENCES orders(order_id))
                  



				   