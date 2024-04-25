package com.github.lucasramallo.project.core.repositories;

import com.github.lucasramallo.project.core.domain.customer.Customer;

public interface CustomerRepository {
    public void persist(Customer customer);
}
