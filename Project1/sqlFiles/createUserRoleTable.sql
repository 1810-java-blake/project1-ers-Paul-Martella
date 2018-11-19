set schema 'public';

create table ers_user_roles (
	user_role_id serial Primary Key,
	user_role text not null
);
