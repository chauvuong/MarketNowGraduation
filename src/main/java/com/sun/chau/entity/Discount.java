package com.sun.chau.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@JsonFilter("filter.discount")
public class Discount {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String code;
  private int quantity;
  @Temporal(TemporalType.TIMESTAMP)
  private Date starDate;
  @Temporal(TemporalType.TIMESTAMP)
  private Date endDate;
  private int discountPer;


  @OneToMany(mappedBy = "discount")
  private List<OrderProduct> orders;
}
