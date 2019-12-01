package com.sun.chau.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@JsonFilter("filter.orderProduct")
public class OrderProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;

  private Date date;
  private Status status;
  private int shipperId;
  private int userId;

  @OneToMany(mappedBy = "orderProduct")
  private List<Item> items;

  @ManyToOne
  @JoinColumn(name = "discount_id")
  private Discount discount;
}
