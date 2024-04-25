package com.github.lucasramallo.project.data.config;

import com.github.lucasramallo.project.core.repositories.AccountRepository;
import com.github.lucasramallo.project.core.repositories.CustomerRepository;
import com.github.lucasramallo.project.core.usecase.account.CreateAccountUseCase;
import com.github.lucasramallo.project.core.usecase.customer.CreateCustomerUseCase;
import com.github.lucasramallo.project.data.repository.AccountRepositoryImpl;
import com.github.lucasramallo.project.data.repository.CustomerRepositoryImpl;
import com.github.lucasramallo.project.data.repository.jpa.JpaAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjection {

    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepositoryImpl();
    }

    @Bean
    public CreateCustomerUseCase createCustomerUseCase() {
        return new CreateCustomerUseCase(customerRepository());
    }

    @Bean
    public AccountRepository accountRepository() {
        return new AccountRepositoryImpl();
    }

//    @Bean
//    public CreateAccountUseCase createAccountUseCase() {
//        return new CreateAccountUseCase(accountRepository());
//    }

    @Bean
    public AccountRepositoryImpl accountRepositoryImpl() {
        return new AccountRepositoryImpl();
    }
}