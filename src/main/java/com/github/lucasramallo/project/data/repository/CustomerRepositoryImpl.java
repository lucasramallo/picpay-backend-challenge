package com.github.lucasramallo.project.data.repository;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.customer.Customer;
import com.github.lucasramallo.project.core.repositories.CustomerRepository;
import com.github.lucasramallo.project.data.entities.AccountEntity;
import com.github.lucasramallo.project.data.entities.CustomerEntity;
import com.github.lucasramallo.project.data.repository.jpa.JpaAccountRepository;
import com.github.lucasramallo.project.data.repository.jpa.JpaCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JpaCustomerRepository jpaCustomerRepository;
    @Autowired
    private AccountRepositoryImpl accountRepository;

    @Override
    public void persist(Customer customer) {
        CustomerEntity customerEntity = domainToEntity(customer);

        jpaCustomerRepository.save(customerEntity);
    }

    public CustomerEntity domainToEntity(Customer customer) {
        return new CustomerEntity(
                customer.getDocument(),
                customer.getName(),
                customer.getEmail(),
                customer.getPasswordHash(),
                customer.getType(),
                accountRepository.domainToEntity(customer.getAccount())
        );
    }
}
