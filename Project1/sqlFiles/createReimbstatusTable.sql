set schema 'public';

create table ers_reimbursement_status (
	reimb_status_id serial Primary Key,
	reimb_status text not null
);
