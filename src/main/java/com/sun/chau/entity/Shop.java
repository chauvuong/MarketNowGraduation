package com.sun.chau.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@JsonFilter("filter.shop")
public class Shop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String name;
  private String address;
  private String phone;
  private String email;
  private String city;
  private String image;
  private String password;

  @Column(columnDefinition = "TEXT")
  private String description;

  @OneToMany(mappedBy = "shop")
  private List<Product> products;
}
