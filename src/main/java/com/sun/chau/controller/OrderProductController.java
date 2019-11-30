package com.sun.chau.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sun.chau.service.OrderProductService;
import com.sun.chau.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/orderProducts")
public class OrderProductController {

  @Autowired
  private OrderProductService orderProductService;

  @GetMapping
  public ResponseEntity getAllOrderProduct()
  {
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(orderProductService.getAll());
    FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("filter.orderProduct", SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter("filter.account", SimpleBeanPropertyFilter.filterOutAllExcept("id","username","email","phone","gender","city","address","birthday","image"))
            .addFilter("filter.shipper", SimpleBeanPropertyFilter.filterOutAllExcept("id","username","email","phone","gender","city","address","birthday","image"));
    mappingJacksonValue.setFilters(filterProvider);
    return new ResponseEntity(mappingJacksonValue, HttpStatus.OK);}


  @GetMapping({"/account/{id}"})
  public ResponseEntity getProductByCategoryId(@PathVariable("id") int id){
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(orderProductService.findAllByAccountId(id));
    FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("filter.orderProduct", SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter("filter.account", SimpleBeanPropertyFilter.filterOutAllExcept("id","username","email","phone","gender","city","address","birthday","image"))
            .addFilter("filter.shipper", SimpleBeanPropertyFilter.filterOutAllExcept("id","username","email","phone","gender","city","address","birthday","image"));
    mappingJacksonValue.setFilters(filterProvider);
    return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
  }
  @GetMapping({"/shipper/{id}"})
  public ResponseEntity getProductByShipperId(@PathVariable("id") int id){
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(orderProductService.findAllByShipperId(id));
    FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("filter.orderProduct", SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter("filter.account", SimpleBeanPropertyFilter.filterOutAllExcept("id","username","email","phone","gender","city","address","birthday","image"))
            .addFilter("filter.shipper", SimpleBeanPropertyFilter.filterOutAllExcept("id","username","email","phone","gender","city","address","birthday","image"));
    mappingJacksonValue.setFilters(filterProvider);
    return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
  }
  @GetMapping({"{id}"})
  public ResponseEntity getOrderProductById(@PathVariable int id){
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(orderProductService.getOrderProductById(id));
    FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("filter.orderProduct", SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter("filter.account", SimpleBeanPropertyFilter.filterOutAllExcept("id","username","email","phone","gender","city","address","birthday","image"))
            .addFilter("filter.shipper", SimpleBeanPropertyFilter.filterOutAllExcept("id","username","email","phone","gender","city","address","birthday","image"));
    mappingJacksonValue.setFilters(filterProvider);
    return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
  }
}
