package com.github.lucasramallo.project.core.usecase.transaction;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.account.exceptions.InsufficientBalanceException;
import com.github.lucasramallo.project.core.domain.customer.Customer;
import com.github.lucasramallo.project.core.domain.customer.exceptions.InvalidCustomerException;
import com.github.lucasramallo.project.core.dtos.TransferRequestDTO;
import com.github.lucasramallo.project.core.usecase.account.GetAccountById;
import com.github.lucasramallo.project.core.usecase.account.SaveAccountUseCase;
import com.github.lucasramallo.project.core.usecase.customer.GetCustomerByAccount;
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

    public UUID execute(TransferRequestDTO transferRequestDTO) {
        Account payer = getAccountById.execute(transferRequestDTO.payer());
        Account payee = getAccountById.execute(transferRequestDTO.payee());

        BigDecimal value = transferRequestDTO.value();

        Customer customerPayer = getCustomerByAccount.execute(payer.getNumber());

        if(payer.getBalance().compareTo(value) < 0) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }

        if(customerPayer.isMerchant()) {
            throw new InvalidCustomerException("Merchant type customer cannot make transfers");
        }

        payer.withdraw(value);
        payee.deposit(value);

        saveAccountUseCase.execute(payer);
        saveAccountUseCase.execute(payee);

        return createTransactionUseCase.execute(value, payer, payee);
    }
}
