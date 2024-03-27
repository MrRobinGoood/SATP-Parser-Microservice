create table company 
(
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	number_inn varchar,
	number_kpp varchar,
	business_address varchar, 
	full_name varchar, 
	web_link varchar, 
	short_name varchar, 
	title varchar not null, 
	type_okvd varchar
);
create table trade_card 
(
	in_favorites boolean, 
	start_price DOUBLE PRECISION, 
	deadline_date_time timestamp not null, 
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	publication_date_time timestamp not null, 
	currency_type varchar, 
	web_link varchar not null, 
	region_name varchar, 
	source_name varchar not null, 
	status varchar not null, 
	terms_contract varchar, 
	title varchar not null, 
	stage varchar not null,
    company_id integer REFERENCES company (id) NOT NULL
);
create table product_item 
(
	count_of integer not null, 
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	delivery_address varchar, 
	description varchar, 
	measure_unit varchar not null, 
	title varchar not null,
	trade_card_id integer REFERENCES trade_card (id)
);
create table documents 
(
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	title varchar not null,
	description varchar, 
	web_link varchar not null,
	trade_card_id integer REFERENCES trade_card (id)
);
create table users 
(
	id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	name varchar not null
);