package com.github.lucasramallo.project.core.domain.transaction;

import com.github.lucasramallo.project.core.domain.account.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "transaction")
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "payer_id", referencedColumnName = "number")
    private Account payer;

    @ManyToOne
    @JoinColumn(name = "payee_id", referencedColumnName = "number")
    private Account payee;

    public Transaction(BigDecimal value, Account payer, Account payee) {
        this.id = UUID.randomUUID();
        this.value = value;
        this.payer = payer;
        this.payee = payee;
    }
}