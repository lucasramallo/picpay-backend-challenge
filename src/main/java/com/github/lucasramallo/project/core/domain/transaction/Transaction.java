package com.github.lucasramallo.project.core.domain.transaction;
import com.github.lucasramallo.project.core.domain.account.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private UUID id;
    private BigDecimal value;
    private Account payer;
    private Account payee;
}
