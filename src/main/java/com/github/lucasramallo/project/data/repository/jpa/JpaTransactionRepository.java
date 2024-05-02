package com.github.lucasramallo.project.data.repository.jpa;

import com.github.lucasramallo.project.core.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTransactionRepository extends JpaRepository<Transaction, UUID> {
}
