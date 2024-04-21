CREATE TABLE `transaction` (
    id VARCHAR(100) NOT NULL,
    value DECIMAL(15,2) NOT NULL,
    payer_id varchar(100) NOT NULL,
    payee_id varchar(100) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT transaction_pk PRIMARY KEY (id),
    CONSTRAINT transaction_account_FK FOREIGN KEY (payer_id) REFERENCES account(`number`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT transaction_account_FK_1 FOREIGN KEY (payee_id) REFERENCES account(`number`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;
