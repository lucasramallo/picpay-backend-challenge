package com.github.lucasramallo.project.core.usecase.customer;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.customer.Customer;
import com.github.lucasramallo.project.core.dtos.CustomerRequestDTO;
import com.github.lucasramallo.project.core.usecase.account.CreateAccountUseCase;
import com.github.lucasramallo.project.data.repository.jpa.JpaCustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCase {
    @Autowired
    private JpaCustomerRepository repository;
    @Autowired
    private CreateAccountUseCase createAccountUseCase;

    @Transactional
    public void execute(CustomerRequestDTO userRequestDTO) {
        Account newAccount = createAccountUseCase.execute();

        Customer newCustomer = new Customer(
                userRequestDTO.document(),
                userRequestDTO.name(),
                userRequestDTO.email(),
                userRequestDTO.password(),
                userRequestDTO.type(),
                newAccount
        );

        repository.save(newCustomer);
    }
}