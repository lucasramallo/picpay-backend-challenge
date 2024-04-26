package com.github.lucasramallo.project.data.repository.jpa;

import com.github.lucasramallo.project.core.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<Customer, String> {
}
