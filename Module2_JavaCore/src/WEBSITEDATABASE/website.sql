drop database if exists website;
create database website;
use website;
create table suppliers(
id_suppliers varchar(10) not null primary key,
name varchar(100) not null,
email varchar(50) not null,
phone_number varchar(20),
address varchar(500)
);



create table categories(
id_categories varchar(10) not null primary key,
name varchar(50) not null,
description varchar(500)
);
create table products(
id_products varchar(10) not null primary key,
name varchar(50) not null,
image_url varchar(1000) not null,
price decimal(18.2),
discount decimal(18.2),
stock decimal(18.2),
id_categories varchar(10),
id_suppliers varchar(10),
description varchar(1000),
constraint fk_products_1 foreign key (id_categories) references categories(id_categories) on delete cascade,
constraint fk_products_2 foreign key (id_suppliers) references suppliers(id_suppliers) on delete cascade
);
create table employees(
id_employees varchar(10) not null primary key,
first_name varchar(50) not null,
last_name varchar(50) not null,
phone_number varchar(20),
address varchar(500) not null,
email varchar(50) not null,
birthday datetime
);
create table customers(
id_customers varchar(10) not null primary key,
first_name varchar(50) not null,
last_name varchar(50) not null,
phone_number varchar(20),
address varchar(500) not null,
email varchar(50) not null,
birthday date
);
create table orders(
id_orders varchar(10) not null primary key,
created_date datetime not null,
shipped_date datetime,
status varchar(50) not null,
description varchar(1000),
shipping_address varchar(500) not null,
shipping_Oty varchar(50) not null,
payment_type varchar(20) not null,
id_customers varchar(10),
id_employees varchar(10),
constraint fk_orders_1 foreign key (id_customers) references customers(id_customers) on delete cascade,
constraint fk_orders_2 foreign key (id_employees) references employees(id_employees) on delete cascade
);
create table orderdetails(
id_orderdetails varchar(10) not null primary key,
id_orders varchar(10),
id_products varchar(10),
quantity decimal(18,2),
constraint fk_orderdetails_1 FOREIGN KEY (id_orders) references orders(id_orders) on delete cascade,
constraint fk_orderdetails_2 foreign key (id_products) references products(id_products) on delete cascade
);

-- suppliers

INSERT INTO suppliers 
VALUES ("SL01","SONY","EMAILSL01",09181,"GIALAI");

INSERT INTO suppliers 
VALUES ("SL02","SAMSUNG","EMAILSL02",90881,"DANANG");

INSERT INTO suppliers 
VALUES ("SL03","TOSHIBA","EMAILSL03",095182,"QUANGNAM");

INSERT INTO suppliers 
VALUES ("SL04","APPLE","EMAILSL04",090651,"HATINH");

INSERT INTO suppliers 
VALUES ("SL05","NAMESL01","EMAILSL05",0902222651,"CHUSE");


--  categories
INSERT INTO categories
VALUES ("CG01","NAMECG01","descriptioncg01");

INSERT INTO categories
VALUES ("CG02","NAMECG02","descriptioncg02");

INSERT INTO categories
VALUES ("CG03","NAMECG01","descriptioncg03");

-- products


INSERT INTO products
VALUES ("PD01","NAMEPD01","IMAGE01","100000","10","3","CG01","SL01","descriptionpr01");

INSERT INTO products
VALUES ("PD02","NAMEPD02","IMAGE02","200000","20","4","CG02","SL02","descriptionpr02");

INSERT INTO products
VALUES ("PD03","NAMEPD03","IMAGE03","300000","30","6","CG03","SL03","descriptionpr03");


-- employees

INSERT INTO employees
VALUES ("EP01","FNE01","LNE01","123","addressep01","EMAILEP01","2020-03-25");

INSERT INTO employees
VALUES ("EP02","FNE02","LEN02","1234","addressep02","EMAILEP02","2000-02-02");

INSERT INTO employees
VALUES ("EP03","FNE03","LNE03","1235","addressep03","EMAILEP03","2000-03-03");

-- customers


INSERT INTO customers
VALUES ("CT01","FNC01","LNE01","1235","HaiChau","EMAILct01","1999-03-25");

INSERT INTO customers
VALUES ("CT02","FNC02","LNE02","12354","addressct02","EMAILct02","1990-02-02");

INSERT INTO customers
VALUES ("CT03","FNC03","LNE03","123554","addressct03","EMAILct03","1999-03-03");

-- orders

INSERT INTO orders
VALUES ("OD01","2020-01-01","2020-01-01","STATUSOD01","descriptionod01",
"shippingAddressod01","shippingOtyOD01","CREADIT CARD","CT01","EP01");

INSERT INTO orders
VALUES ("OD02","2020-02-02","2020-02-02","CANCELED","descriptionod02","HaNoi"
,"shippingOtyOD01","paymenttypeod01","CT01","EP01");

INSERT INTO orders
VALUES ("OD03","2020-03-03","2020-03-25","COMPLETED","descriptionod03","shippingAddressod03"
,"shippingOtyOD03","CASH","CT03","EP03");


-- orderdetails

INSERT INTO orderdetails
VALUES ("OT01","OD01","PD01","0.1");


INSERT INTO orderdetails
VALUES ("OT02","OD02","PD01","0.2");


INSERT INTO orderdetails
VALUES ("OT03","OD03","PD03","0.3");


-- Câu 1: Viết câu lệnh UPDATE để cập nhật Price với điều kiện: Các mặt hàng có Price <= 100000 thì tăng thêm 10%

update products 
set products.price = products.price * 0.1
where products.price <= 10000;

select * from products;

-- Câu 2: Viết câu lệnh UPDATE để cập nhật DISCOUNT với điều kiện: Các mặt hàng có Discount <= 10% thì tăng thêm 5%

update products 
set products.discount = products.discount * 0.05
where products.discount <= 10;

select * from products;

-- Câu 3: Hiển thị tất cả các mặt hàng có giảm giá <= 10%

select  products.id_products,products.name 
from products
where products.discount <= 20;


-- Câu 4: Hiển thị tất cả các mặt hàng có tồn kho <= 5

select  products.id_products,products.name 
from products
where products.stock <= 5;


-- câu 5 : Hiển thị tất cả các khách hàng có địa chỉ ở Quận Hải Châu

select customers.id_customers,customers.first_name,customers.last_name
from customers
where  customers.address like "HaiChau";
  

-- câu 6: Hiển thị tất cả các khách hàng có năm sinh 1990

select *
from customers
where year(customers.birthday) = 1990;


-- câu 7: Hiển thị tất cả các khách hàng có sinh nhật là hôm nay
select *
from customers
where day(customers.birthday) = day(curdate()) 
and month(customers.birthday) = month(curdate());

-- câu 8: Hiển thị tất cả các đơn hàng có trạng thái là COMPLETED
select *
from orders
where orders.status like "COMPLETED";


-- câu 9: Hiển thị tất cả các đơn hàng có trạng thái là COMPLETED trong ngày hôm nay

select *
from orders
where orders.status like "COMPLETED" 
and date(orders.shipped_date) = curdate();


-- câu 10: Hiển thị tất cả các đơn hàng có trạng thái là CANCELED

select *
from orders
where orders.status like "CANCELED";


-- câu 11: Hiển thị tất cả các đơn hàng có hình thức thanh toán là CASH

select *
from orders
where orders.payment_type like "CASH";

-- câu 12: Hiển thị tất cả các đơn hàng có hình thức thanh toán là CREADIT CARD

select *
from orders
where orders.payment_type like "CREADIT CARD";


-- câu 13: Hiển thị tất cả các đơn hàng có địa chỉ giao hàng là Hà Nội

select *
from orders
where orders.shipping_address like "HaNoi";


-- câu 14: Hiển thị tất cả các nhân viên có sinh nhật là hôm nay
select *
from employees
where day(employees.birthday) = day(curdate()) 
and month(employees.birthday) = month(curdate());


-- câu 15: Hiển thị tất cả các nhà cung cấp có tên là: (SONY, SAMSUNG, TOSHIBA, APPLE)

select *
from suppliers
where suppliers.name like "SONY" or suppliers.name like "SAMSUNG" or suppliers.name like "TOSHIBA" or 
suppliers.name like "APPLE";


-- câu 16: Hiển thị tất cả các mặt hàng cùng với CategoryName

select  products.id_products,products.name,products.image_url,products.price,products.discount,
products.stock,products.id_suppliers,products.id_categories,categories.name
from products , categories
where products.id_categories = categories.id_categories;


-- câu 17: Hiển thị tất cả các đơn hàng cùng với thông tin chi tiết khách hàng (Customer)
select * from customers join orders on customers.id_customers = orders.id_customers;

-- câu 18: Hiển thị tất cả các mặt hàng cùng với thông tin chi tiết của Category và Supplier
select * from products join categories on products.id_categories = categories.id_categories
join suppliers on products.id_suppliers =suppliers.id_suppliers ;

-- câu 19: Hiển thị tất cả danh mục (Categories) với số lượng hàng hóa trong mỗi danh mục(Viết 2 cách) (edited)
 -- c1:
select categories.*,sum(stock) 
from categories join products on products.id_categories=categories.id_categories
group by categories.id_categories; 
-- c2:
select categories.*,sum(stock) 
from products, categories
  where products.id_categories =categories.id_categories
 group by categories.id_categories;
	

-- câu 20: Hiển thị tất cả nhà cung cấp (Suppliers) với số lượng hàng hóa mỗi nhà cung cấp(Viết 2 cách)
-- c1:
select suppliers.*,sum(stock)
 from suppliers join products on suppliers.id_suppliers =products.id_suppliers
 group by suppliers.id_suppliers;
-- c2:
select suppliers.*,sum(stock) 
from suppliers, products 
where suppliers.id_suppliers =products.id_suppliers 
group by suppliers.id_suppliers;

-- câu 21: Hiển thị tất cả các mặt hàng được bán trong khoảng từ ngày, đến ngày(Khoảng cách ngày các bạn tuỳ chọn theo data phù hợp với mỗi người) (edited) 
select * 
from orderdetails join orders on orderdetails.id_orders = orders.id_orders 
join products on  orderdetails.id_products =  products.id_products
join customers on customers.id_customers = orders.id_customers
where shipped_date between '2020-01-01' and '2020-03-25';



-- câu 22: Hiển thị tất cả các khách hàng mua hàng trong khoảng từ ngày, đến ngày((Khoảng cách ngày các bạn tuỳ chọn theo data phù hợp với mỗi người)) (edited) 
select distinct orders.id_orders,customers.id_customers,customers.first_name,customers.last_name,customers.phone_number
from orders join orderdetails on orderdetails.id_orders=orderdetails.id_orders
join products on orderdetails.id_products=products.id_products join customers  on customers.id_customers=orders.id_customers
where shipped_date between '2020-01-01' and '2020-03-25';

-- Câu 23: Hiển thị tất cả các khách hàng mua hàng (với tổng số tiền) trong khoảng từ ngày, đến ngày(viêt bằng 2 cách, ngày tuỳ chọn )
select distinct orders.id_orders,customers.id_customers,customers.first_name,customers.last_name,customers.phone_number,
sum(products.price) as totalmoney
from orders join orderdetails on orderdetails.id_orders=orderdetails.id_orders
join products on orderdetails.id_products=products.id_products 
join customers  on customers.id_customers=orders.id_customers
where shipped_date between '2020-01-01' and '2020-03-25'
group by orders.id_orders;

-- câu 24: Hiển thị tất cả đơn hàng với tổng số tiền
select orders.id_orders , ((products.price* products.discount)*orderdetails.quantity) as totalmoney
from orderdetails join orders on orderdetails.id_orders = orders.id_orders 
join products on  orderdetails.id_products =  products.id_products
group by orders.id_orders;


-- câu 25: Hiển thị tất cả các nhân viên bán hàng với tổng số tiền bán được

select employees.id_employees,concat(employees.first_name, " " ,employees.last_name) as full_name , ((products.price* products.discount)*orderdetails.quantity) as totalmoney
from orders  join orderdetails on orders.id_orders  =  orderdetails.id_orders
join products on  orderdetails.id_products =  products.id_products
join employees on orders.id_employees = employees.id_employees
group by employees.id_employees;




