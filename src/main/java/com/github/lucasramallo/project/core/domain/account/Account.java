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
    private UUID id;
    private BigDecimal balance;

    public Account(BigDecimal balance) {
        this.id = UUID.randomUUID();
        this.balance = BigDecimal.ZERO;
    }
}
