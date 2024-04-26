package com.github.lucasramallo.project.data.repository.jpa;

import com.github.lucasramallo.project.core.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAccountRepository extends JpaRepository<Account, String> {

}
