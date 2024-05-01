package com.github.lucasramallo.project.data.repository.jpa;

import com.github.lucasramallo.project.core.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCustomerRepository extends JpaRepository<Customer, String> {
    Customer findByAccountNumber(String accountNumber);
}
