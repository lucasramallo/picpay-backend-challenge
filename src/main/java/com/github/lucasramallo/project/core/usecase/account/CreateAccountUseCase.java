package com.github.lucasramallo.project.core.usecase.account;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.repositories.AccountRepository;
import com.github.lucasramallo.project.data.repository.AccountRepositoryImpl;
import lombok.NoArgsConstructor;

public class CreateAccountUseCase {
    private final AccountRepository repository;

    public CreateAccountUseCase() {
        this.repository = new AccountRepositoryImpl();
    }


    public Account execute() {
        Account newAccount = new Account();

        repository.persist(newAccount);

        return newAccount;
    }
}
