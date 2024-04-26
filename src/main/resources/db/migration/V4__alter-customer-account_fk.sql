ALTER TABLE picpay_challenge.customer DROP FOREIGN KEY customer_account_FK;
ALTER TABLE picpay_challenge.customer ADD CONSTRAINT customer_account_FK FOREIGN KEY (account_id) REFERENCES picpay_challenge.account(`number`);
