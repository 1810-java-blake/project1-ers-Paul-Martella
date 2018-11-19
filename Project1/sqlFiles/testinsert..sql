set schema 'public';

insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
values (100, NOW(), Now(), 'wat', '1', '1','1','1');
