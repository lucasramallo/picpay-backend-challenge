package com.github.lucasramallo.project.core.domain.account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Random;

@Entity(name = "account")
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
public class Account {

    @Id
    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private BigDecimal balance;

    public Account() {
        this.number = generateAccounNumber();
        this.balance = BigDecimal.ZERO;
    }

    private String generateAccounNumber() {
        Random random = new Random();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int randomNumber = random.nextInt(10);
            stringBuilder.append(randomNumber);
        }

        return stringBuilder.toString();
    }

}
