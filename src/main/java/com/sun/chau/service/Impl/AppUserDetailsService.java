package com.sun.chau.service.Impl;


import com.sun.chau.entity.Account;
import com.sun.chau.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppUserDetailsService implements UserDetailsService {
  @Autowired
  private AccountRepository accountRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Account account = accountRepository.findAccountByUsername(username);

    if (account == null) {
      throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
    }

    List<GrantedAuthority> authorities = new ArrayList<>();
    account.getRoles().forEach(role -> {
      authorities.add(new SimpleGrantedAuthority(role.getName()));
    });
    UserDetails userDetails = new org.springframework.security.core.userdetails.
        User(account.getUsername(), account.getPassword(), authorities);

    return userDetails;
  }
}
