package com.sun.chau.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@JsonFilter("filter.role")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String name;

  @OneToMany(mappedBy = "role")
  private List<Account> accounts;
}
