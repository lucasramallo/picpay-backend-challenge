package com.github.lucasramallo.project.core.repositories;

import com.github.lucasramallo.project.core.domain.account.Account;

public interface AccountRepository {
    public void persist(Account account);
}
