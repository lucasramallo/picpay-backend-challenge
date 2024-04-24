package com.github.lucasramallo.project.core.usecase.account;

import com.github.lucasramallo.project.core.domain.account.Account;

public class CreateAccountUseCase {
    public Account execute() {
        return new Account();
    }
}
