package com.sun.chau.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Brand {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String name;
  private String address;
  private String email;
  private String image;
  private String description;


  @OneToMany(mappedBy = "brand")
  private List<Product> products;
}
