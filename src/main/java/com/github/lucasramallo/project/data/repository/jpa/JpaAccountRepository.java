package com.github.lucasramallo.project.data.repository.jpa;

import com.github.lucasramallo.project.data.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAccountRepository extends JpaRepository<AccountEntity, String> {

}
