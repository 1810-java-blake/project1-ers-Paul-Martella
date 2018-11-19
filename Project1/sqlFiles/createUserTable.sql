set schema 'public';

create table ers_users (ers_user_id serial Primary Key, ers_username text not null, ers_password text not null, user_firstname text not null, user_lastname text not null, user_email text not null, user_role_id numeric not null);
