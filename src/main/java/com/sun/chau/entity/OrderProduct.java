package com.sun.chau.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;

import javax.persistence.*;
import java.text.DateFormat;
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

  @ManyToOne
  @JoinColumn(name = "account_id")
  private Account account;

  @OneToMany(mappedBy = "orderProduct")
  private List<Item> items;

  @ManyToOne
  @JoinColumn(name = "shipper_id")
  private Shipper shipper;

  @ManyToOne
  @JoinColumn(name = "discount_id")
  private Discount discount;
}
