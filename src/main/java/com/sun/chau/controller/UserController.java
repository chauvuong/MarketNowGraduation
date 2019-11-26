package com.sun.chau.controller;

import com.sun.chau.entity.Account;
import com.sun.chau.service.AccountService;
import org.bouncycastle.asn1.esf.OcspListID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api-public/user")
public class UserController {
  @Autowired
  private AccountService accountService;

  @PostMapping("/create")
  public ResponseEntity createAccount(@RequestParam String username, @RequestParam String password) {
    if (accountService.findByUsername(username) != null) {
      return new ResponseEntity("User already exits", HttpStatus.BAD_REQUEST);
    }
    accountService.addAccount(new Account(username, password));
    return new ResponseEntity("Create account success", HttpStatus.OK);
  }
}
