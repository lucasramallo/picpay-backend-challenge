package com.github.lucasramallo.project.data.repository;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.repositories.AccountRepository;
import com.github.lucasramallo.project.data.entities.AccountEntity;
import com.github.lucasramallo.project.data.repository.jpa.JpaAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountRepositoryImpl implements AccountRepository {
    @Autowired
    private JpaAccountRepository jpaAccountRepository;

    @Override
    public void persist(Account account) {
        AccountEntity newAccountEntity = domainToEntity(account);

        jpaAccountRepository.save(newAccountEntity);
    }

    public AccountEntity domainToEntity(Account account) {
        return new AccountEntity(
            account.getNumber(),
            account.getBalance()
        );
    }
}
