drop table if exists learningresources;
create table learningresources(
learning_resource_id int primary key,
learning_resource_name varchar(100),
cost_price double,
selling_price double,
learning_resource_status varchar(100),
created_date varchar(100),
published_date varchar(100),
retired_date varchar(100)
);