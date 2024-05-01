package com.github.lucasramallo.project.core.usecase.customer;

import com.github.lucasramallo.project.core.domain.customer.Customer;
import com.github.lucasramallo.project.data.repository.jpa.JpaAccountRepository;
import com.github.lucasramallo.project.data.repository.jpa.JpaCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerByAccount {
    @Autowired
    private JpaCustomerRepository repository;

    public Customer execute(String accountNumber) {
        return repository.findByAccountNumber(accountNumber);
    }
}
