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
  private Gender gender;
  private String phone;
  private String email;
  private Date birthday;
  private String address;
  private String city;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "account_role",
      joinColumns = @JoinColumn(name = "account_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private List<Role> roles;
}
