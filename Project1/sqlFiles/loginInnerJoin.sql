set schema 'public';

select * from ers_users inner join ers_user_roles on ers_user_roles.user_role_id=ers_users.user_role_id;

