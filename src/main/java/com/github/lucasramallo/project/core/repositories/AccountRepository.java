package com.github.lucasramallo.project.core.repositories;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.customer.Customer;

public interface AccountRepository {
    public void persist(Account account);
}
