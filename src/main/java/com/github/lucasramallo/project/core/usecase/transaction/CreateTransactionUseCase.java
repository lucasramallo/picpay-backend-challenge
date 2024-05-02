package com.github.lucasramallo.project.core.usecase.transaction;


import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.transaction.Transaction;
import com.github.lucasramallo.project.data.repository.jpa.JpaTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class CreateTransactionUseCase {
    @Autowired
    private JpaTransactionRepository repository;

    public UUID execute(BigDecimal value, Account payer, Account payee){
        Transaction newTransaction = new Transaction(value, payer, payee);

        repository.save(newTransaction);

        return newTransaction.getId();
    }
}
