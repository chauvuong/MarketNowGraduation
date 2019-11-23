package com.sun.chau.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@JsonFilter("filter.category")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String name;

  @OneToMany(mappedBy = "category")
  private List<Product> products;
}
