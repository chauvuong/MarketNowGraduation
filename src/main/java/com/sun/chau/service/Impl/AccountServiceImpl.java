package com.sun.chau.service.Impl;

import com.sun.chau.entity.Account;
import com.sun.chau.repository.AccountRepository;
import com.sun.chau.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
  @Value("${security.encoding-strength}")
  private Integer encodingStrength;

  @Autowired
  private AccountRepository accountRepository;


  @Override
  public Account addAccount(Account account) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      account.setPassword(encoder.encode(account.getPassword()));
      return accountRepository.save(account);
  }
}
