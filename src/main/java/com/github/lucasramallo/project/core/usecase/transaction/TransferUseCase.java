package com.github.lucasramallo.project.core.usecase.transaction;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.account.exceptions.InsufficientBalanceException;
import com.github.lucasramallo.project.core.domain.customer.Customer;
import com.github.lucasramallo.project.core.domain.customer.exceptions.InvalidCustomerException;
import com.github.lucasramallo.project.core.domain.transaction.exceptions.UnauthorizedTransactionException;
import com.github.lucasramallo.project.core.dtos.TransferRequestDTO;
import com.github.lucasramallo.project.core.service.EmailService;
import com.github.lucasramallo.project.core.usecase.account.GetAccountById;
import com.github.lucasramallo.project.core.usecase.account.SaveAccountUseCase;
import com.github.lucasramallo.project.core.usecase.customer.GetCustomerByAccount;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class TransferUseCase {
    @Autowired
    private GetAccountById getAccountById;

    @Autowired
    private GetCustomerByAccount getCustomerByAccount;

    @Autowired
    private SaveAccountUseCase saveAccountUseCase;

    @Autowired
    private CreateTransactionUseCase createTransactionUseCase;

    @Autowired
    private AuthorizeTransactionUseCase authorizeTransactionUseCase;

    @Autowired
    private EmailService emailService;


    public UUID execute(TransferRequestDTO transferRequestDTO) {
        Account payerAccount = getAccountById.execute(transferRequestDTO.payer());
        Account payeeAccount = getAccountById.execute(transferRequestDTO.payee());
        BigDecimal value = transferRequestDTO.value();
        Customer customerPayer = getCustomerByAccount.execute(payerAccount.getNumber());
        Customer customerPayee = getCustomerByAccount.execute(payeeAccount.getNumber());

        validateTransaction(value, payerAccount, customerPayer);

        UUID transactionId = makeTransaction(value, payerAccount, payeeAccount);

        if(customerPayee.isMerchant()) {
            emailService.sendEmail(customerPayee);
        }

        return transactionId;
    }

    @Transactional
    private UUID makeTransaction(BigDecimal value, Account payerAccount, Account payeeAccount) {
        payerAccount.withdraw(value);
        payeeAccount.deposit(value);
        saveAccountUseCase.execute(payerAccount);
        saveAccountUseCase.execute(payeeAccount);

        return createTransactionUseCase.execute(value, payerAccount, payeeAccount);
    }

    private void validateTransaction(BigDecimal value, Account payerAccount, Customer customerPayer) {
        if(payerAccount.getBalance().compareTo(value) < 0) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }

        if(customerPayer.isMerchant()) {
            throw new InvalidCustomerException("Merchant type customer cannot make transfers");
        }

        if(!authorizeTransactionUseCase.execute()) {
            throw new UnauthorizedTransactionException("Unauthorized Transaction");
        }
    }
}