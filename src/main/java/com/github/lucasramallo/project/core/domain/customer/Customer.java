package com.github.lucasramallo.project.core.domain.customer;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private String document;
    private String name;
    private String email;
    private String passwordHash;
    private CustomerType type;
    private Account account;
}