package com.github.lucasramallo.project.data.repository.jpa;

import com.github.lucasramallo.project.data.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, String> {
}
