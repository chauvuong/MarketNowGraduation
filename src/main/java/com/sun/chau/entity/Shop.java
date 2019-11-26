package com.sun.chau.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Shop extends Account {
  @Column(columnDefinition = "TEXT")
  private String description;

  @OneToMany(mappedBy = "shop")
  private List<Product> products;

  public Shop(String username, String password) {
    super(username, password);
  }
}
