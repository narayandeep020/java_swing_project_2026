create schema if not exists bus_booking_db;
use bus_booking_db ;
create table if not exists booking_detail (

    user_Name varchar (50) not null,
    s_source varchar (60),
    destination varchar(60),
    no_of_passenger varchar(60),
    bus_time  varchar(60),
    journey_date    varchar(60),
    paid_amt   varchar(60)
    );