package com.sun.chau.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@JsonFilter("filter.shipper")
public class Shipper {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String username;
  private String email;
  private String phone;
  private String password;
  private Gender Gender;
  private String city;
  private String address;
  private Date birthday;
  private int rating;
  private String image;

  @OneToMany(mappedBy = "shipper")
  private List<OrderProduct> orderProducts;
}
