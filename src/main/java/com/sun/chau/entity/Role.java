package com.sun.chau.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String name;

  @ManyToMany(mappedBy = "roles")
  private List<Account> accounts;
}
