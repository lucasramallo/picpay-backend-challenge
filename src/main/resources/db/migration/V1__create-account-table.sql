CREATE TABLE picpay_challenge.account (
	balance DECIMAL(15,2) NULL,
	`number` varchar(100) NOT NULL,
	CONSTRAINT account_pk PRIMARY KEY (`number`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;