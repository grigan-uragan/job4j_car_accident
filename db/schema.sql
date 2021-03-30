create table rules(
    id serial primary key,
    name varchar(255)
);

create table types(
    id serial primary key,
    name varchar(255)
);
create table accidents(
    id serial primary key,
    name varchar(255),
    text varchar(2000),
    address varchar(255),
    type_id int references types(id)
);

create table rules_accident(
    rule_id int references rules(id),
    accident_id int references accidents(id),
    primary key(rule_id, accident_id)
);