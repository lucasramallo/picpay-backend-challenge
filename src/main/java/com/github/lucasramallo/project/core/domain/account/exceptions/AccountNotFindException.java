package com.github.lucasramallo.project.core.domain.account.exceptions;

public class AccountNotFindException extends RuntimeException{
    public AccountNotFindException(String message) {
        super(message);
    }
}
