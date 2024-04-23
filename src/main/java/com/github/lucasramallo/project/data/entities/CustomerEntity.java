package com.github.lucasramallo.project.data.entities;

import com.github.lucasramallo.project.core.domain.customer.enums.CustomerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "customer")
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @Column(nullable = false)
    private String document;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private CustomerType type;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;
}