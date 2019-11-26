package com.sun.chau.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String username;
  private String password;
  private String phone;
  private String email;
  private Gender gender;
  private Date birthday;
  private String address;
  private String city;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  @OneToMany(mappedBy = "account")
  private List<OrderProduct> orderProducts;

  public Account(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
