package com.github.lucasramallo.project.core.usecase.account;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.data.repository.jpa.JpaAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveAccountUseCase {
    @Autowired
    private JpaAccountRepository accountRepository;

    public void execute(Account newAccount) {
        accountRepository.save(newAccount);
    }
}
