set schema 'public';

create table ers_reimbursement_type (
	reimb_type_id serial Primary Key,
	reimb_type text not null
);
