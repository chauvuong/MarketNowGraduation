package com.sun.chau.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Shipper extends Account {
  private int rating;

  @OneToMany(mappedBy = "shipper")
  private List<OrderProduct> orderProducts;

  public Shipper(String username, String password) {
    super(username, password);
  }
}
