create table t_coffee (
    id bigint not null auto_increment,
    name varchar(255),
    create_time timestamp,
    update_time timestamp,
    primary key (id)
);