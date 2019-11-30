package com.sun.chau.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@JsonFilter("filter.account")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String username;
  private String phone;
  private String email;
  private String password;
  private Gender gender;
  private String city;
  private String address;
  private Date birthday;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  @OneToMany(mappedBy = "account")
  private List<OrderProduct> orderProducts;
}
