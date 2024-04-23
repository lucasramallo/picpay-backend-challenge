package com.github.lucasramallo.project.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "account")
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    @Id
    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private BigDecimal balance;
}
