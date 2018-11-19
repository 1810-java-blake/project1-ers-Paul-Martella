set schema 'public';

create table ers_reimbursement (
	reimb_id serial Primary Key,
	reimb_amount numeric not null,
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_description text,
	reimb_receipt text,
	reimb_author numeric,
	reimb_resolver numeric,
	reimb_status_id numeric,
	reimb_type_id numeric
);
