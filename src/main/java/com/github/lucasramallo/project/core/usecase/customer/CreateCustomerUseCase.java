package com.github.lucasramallo.project.core.usecase.customer;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.customer.Customer;
import com.github.lucasramallo.project.core.domain.customer.enums.CustomerType;
import com.github.lucasramallo.project.core.dtos.CustomerRequestDTO;
import com.github.lucasramallo.project.core.repositories.CustomerRepository;
import com.github.lucasramallo.project.core.usecase.account.CreateAccountUseCase;
import com.github.lucasramallo.project.data.entities.AccountEntity;
import com.github.lucasramallo.project.data.repository.jpa.JpaAccountRepository;
import com.github.lucasramallo.project.data.repository.jpa.JpaCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateCustomerUseCase {
    private CustomerRepository repository;

    public CreateCustomerUseCase(CustomerRepository repository) {
        this.repository = repository;
    }

    public void execute(CustomerRequestDTO userRequestDTO) {
        Account newAccount = new CreateAccountUseCase().execute();

        Customer newCustomer = new Customer(
                userRequestDTO.document(),
                userRequestDTO.name(),
                userRequestDTO.email(),
                userRequestDTO.password(),
                CustomerType.COMMON,
                newAccount
        );

        repository.persist(newCustomer);
    }
}