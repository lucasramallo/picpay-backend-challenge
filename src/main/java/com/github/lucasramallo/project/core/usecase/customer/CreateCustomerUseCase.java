package com.github.lucasramallo.project.core.usecase.customer;

import com.github.lucasramallo.project.core.domain.account.Account;
import com.github.lucasramallo.project.core.domain.customer.Customer;
import com.github.lucasramallo.project.core.dtos.CustomerRequestDTO;
import com.github.lucasramallo.project.core.usecase.account.CreateAccountUseCase;

public class CreateCustomerUseCase {
    public void execute(CustomerRequestDTO userRequestDTO) {

        Account newAccount = new CreateAccountUseCase().execute();

        Customer newCustomer = new Customer(
                userRequestDTO.document(),
                userRequestDTO.name(),
                userRequestDTO.email(),
                userRequestDTO.password(),
                userRequestDTO.type(),
                newAccount
        );
    }
}