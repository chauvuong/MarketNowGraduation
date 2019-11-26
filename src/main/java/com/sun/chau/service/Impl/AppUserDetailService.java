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

@Component("userDetailService")
public class AppUserDetailService implements UserDetailsService {
  @Autowired
  private AccountRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    Account user = userRepository.findAccountByUsername(s);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
    }

    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

    UserDetails userDetails = new org.springframework.security.core.userdetails.
        User(user.getUsername(), user.getPassword(), authorities);

    return userDetails;
  }
}
