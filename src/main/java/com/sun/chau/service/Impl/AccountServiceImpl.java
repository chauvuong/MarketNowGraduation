package com.sun.chau.service.Impl;

import com.sun.chau.entity.Account;
import com.sun.chau.repository.AccountRepository;
import com.sun.chau.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private PasswordEncoder bCryptPasswordEncoder;

  @Override
  public void addAccount(Account account) {
    account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
    accountRepository.save(account);
  }

  @Override
  public Account findByUsername(String username) {
    System.out.println("find user" + username);
    return accountRepository.findAccountByUsername(username);
  }
}
