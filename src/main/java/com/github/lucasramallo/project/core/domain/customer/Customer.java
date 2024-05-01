package com.github.lucasramallo.project.core.domain.customer;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.customer.enums.CustomerType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


@Entity(name = "customer")
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
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
    @Enumerated(EnumType.STRING)
    private CustomerType type;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Customer(
            String document,
            String name,
            String email,
            String password,
            CustomerType type,
            Account account
    ) {
        this.document = document;
        this.name = name;
        this.email = email;
        this.type = type;
        this.passwordHash = passwordToHash(password);
        this.account = account;
    }

    public String passwordToHash(String password) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = algorithm.digest(password.getBytes(StandardCharsets.UTF_8));
            return Arrays.toString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isCommon(){
        return type == CustomerType.COMMON;
    }

    public boolean isMerchant(){
        return type == CustomerType.MERCHANT;
    }
}