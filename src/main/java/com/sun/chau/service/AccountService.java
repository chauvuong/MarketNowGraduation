package com.sun.chau.service;

import com.sun.chau.entity.Account;

public interface AccountService {
  void addAccount(Account account);
  Account findByUsername(String username);
}
