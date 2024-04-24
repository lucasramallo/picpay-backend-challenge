package com.github.lucasramallo.project.core.domain.customer;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.customer.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
public class Customer {
    private String document;

    private String name;
    private String email;
    private String passwordHash;
    private CustomerType type;
    private Account account;

    public Customer(String document, String name, String email, String password, CustomerType type, Account account) {
        this.document = document;
        this.name = name;
        this.email = email;
        this.type = type;
        this.passwordHash = password;
        this.account = account;
    }

    public void passwordToHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = algorithm.digest(password.getBytes(StandardCharsets.UTF_8));

        this.passwordHash = Arrays.toString(messageDigest);
    }
}