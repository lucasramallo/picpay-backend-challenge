CREATE TABLE customer (
	document varchar(100) NOT NULL,
	name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	`type` ENUM('COMMON', 'MERCHANT') NOT NULL,
	password_hash varchar(100) NOT NULL,
	account_id varchar(100) NOT NULL,
	CONSTRAINT Customer_PK PRIMARY KEY (document),
	CONSTRAINT customer_account_FK FOREIGN KEY (document) REFERENCES account(`number`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;