package com.github.lucasramallo.project.core.usecase.account;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.account.exceptions.AccountNotFindException;
import com.github.lucasramallo.project.data.repository.jpa.JpaAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAccountById {
    @Autowired
    private JpaAccountRepository repository;

    public Account execute(String accountId) {
        return repository.findById(accountId).orElseThrow(
                () -> new AccountNotFindException("Account " + accountId + "not finded!")
        );
    }
}
