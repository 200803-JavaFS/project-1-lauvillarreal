DROP TABLE IF EXISTS ers_reimbursement;
DROP TABLE IF EXISTS ers_reimbursement_type cascade;
DROP TABLE IF EXISTS ers_reimbursement_status cascade;
DROP TABLE IF EXISTS ers_users cascade;
DROP TABLE IF EXISTS ers_user_roles cascade;

CREATE TABLE ers_reimbursement (
	reim_id SERIAL PRIMARY KEY,
	reim_amount NUMERIC(7,2) NOT NULL,
	reim_submitted TIMESTAMP NOT NULL,
	reim_resolved TIMESTAMP,
	reim_description VARCHAR(250),
	reim_author_fk INTEGER REFERENCES ers_users(ers_users_id) NOT NULL,
	reim_resolver_fk INTEGER REFERENCES ers_users(ers_users_id),
	reim_status_id_fk INTEGER REFERENCES ers_reimbursement_status(reim_status_id) NOT NULL,
	reim_type_id_fk INTEGER REFERENCES ers_reimbursement_type(reim_type_id) NOT NULL 
);

CREATE TABLE ers_users (
	ers_users_id SERIAL PRIMARY KEY,
	ers_username VARCHAR(50) NOT NULL,
	ers_password VARCHAR(50) NOT NULL,
	user_first_name VARCHAR(100) NOT NULL,
	user_last_name VARCHAR(100) NOT NULL,
	user_email VARCHAR(150) NOT NULL,
	user_role_id_fk INTEGER REFERENCES ers_user_roles(ers_user_role_id) NOT NULL,
	UNIQUE(ers_username,user_email)
);

CREATE TABLE ers_user_roles (
	ers_user_role_id SERIAL PRIMARY KEY,
	user_role VARCHAR(100) NOT NULL,

);

CREATE TABLE ers_reimbursement_status (
	reim_status_id SERIAL PRIMARY KEY,
	reim_status VARCHAR(100) NOT NULL,

);

CREATE TABLE ers_reimbursement_type (
	reim_type_id SERIAL PRIMARY KEY,
	reim_type VARCHAR(100) NOT NULL,
	
);

INSERT INTO ers_reimbursement (reim_amount, reim_submitted, reim_resolved, reim_description, reim_author_fk, reim_resolver_fk, reim_status_id_fk, reim_type_id_fk)
	VALUES (100.00, '2016-08-22 19:10:25-07', '2016-08-29 20:10:25-07', 'description', 20, 19, 22, 1);

INSERT INTO ers_reimbursement_status (reim_status) 
VALUES ('created');

INSERT INTO ers_reimbursement_type (reim_type)
VALUES ('certification');

INSERT INTO ers_users (ers_username,ers_password, user_first_name, user_last_name, user_email, user_role_id_fk)
VALUES ('vlad', 'weekend', 'vlad', 'feinberg', 'vlad@gmail.com', 1);

INSERT INTO ers_user_roles (user_role)
VALUES ('employee');

DELETE FROM ers_reimbursement_status WHERE reim_status_id = 25; 
UPDATE ers_reimbursement SET reim_resolver_fk = 19 WHERE reim_id = 3;
