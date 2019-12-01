package com.sun.chau.controller;

import com.sun.chau.entity.Account;
import com.sun.chau.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sun.chau.constant.DefaultPath.ACCOUNT_PUBLIC_PATH;

@RestController
@CrossOrigin
@RequestMapping(ACCOUNT_PUBLIC_PATH)
public class AccountController {
  @Autowired
  private AccountService accountService;

  @PostMapping
  public ResponseEntity createAccount(@RequestBody Account account) {
    accountService.addAccount(account);
    return new ResponseEntity("Create user success!", HttpStatus.OK);
  }
}
