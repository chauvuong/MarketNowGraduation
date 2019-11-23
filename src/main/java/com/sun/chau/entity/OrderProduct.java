package com.sun.chau.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
public class OrderProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private Date date;
  private String status;

  @ManyToOne
  @JoinColumn(name = "account_id")
  private Account account;

  @OneToMany(mappedBy = "orderProduct")
  private List<Item> items;

  @ManyToOne
  @JoinColumn(name = "shipper_id")
  private Shipper shipper;
}
