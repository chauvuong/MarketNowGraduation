package com.sun.chau.repository;

import com.sun.chau.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
  Account findAccountByUsername(String username);
}
