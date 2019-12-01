package com.sun.chau.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sun.chau.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity getAllProduct()
  {
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(productService.getAll());
    FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("filter.product", SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter("filter.category", SimpleBeanPropertyFilter.filterOutAllExcept("id","name","parent_id"));
    mappingJacksonValue.setFilters(filterProvider);
    return new ResponseEntity(mappingJacksonValue, HttpStatus.OK);}

  @GetMapping("/deal")
  public ResponseEntity getDealProduct()
  {
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(productService.getDeal());
    FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("filter.product", SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter("filter.category", SimpleBeanPropertyFilter.filterOutAllExcept("id","name","parent_id"));
    mappingJacksonValue.setFilters(filterProvider);
    return new ResponseEntity(mappingJacksonValue, HttpStatus.OK);}
  @GetMapping({"/category/{id}"})
  public ResponseEntity getProductByCategoryId(@PathVariable("id") int id){
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(productService.findAllByCategoryId(id));
    FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("filter.product", SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter("filter.category", SimpleBeanPropertyFilter.filterOutAllExcept("id","name","parent_id"));
    mappingJacksonValue.setFilters(filterProvider);
    return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
  }
  @GetMapping({"{id}"})
  public ResponseEntity getProductById(@PathVariable int id){
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(productService.getProductById(id));
    FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("filter.product", SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter("filter.category", SimpleBeanPropertyFilter.filterOutAllExcept("id","name","parent_id"));
    mappingJacksonValue.setFilters(filterProvider);
    return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
  }
}
