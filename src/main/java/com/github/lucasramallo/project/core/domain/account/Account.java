package com.github.lucasramallo.project.core.domain.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Account {
    private String number;
    private BigDecimal balance;

    public Account(BigDecimal balance, String number) {
        this.number = number;
        this.balance = BigDecimal.ZERO;
    }
}
