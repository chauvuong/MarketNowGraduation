package com.sun.chau.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sun.chau.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @GetMapping
  public ResponseEntity getAllCategory() {
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(categoryService.getAll());
    FilterProvider filterProvider = new SimpleFilterProvider()
        .addFilter("filter.category", SimpleBeanPropertyFilter.serializeAllExcept())
        .addFilter("filter.product", SimpleBeanPropertyFilter.filterOutAllExcept("id","name","price","unit","stock","sku","description","review","rating","shop_id","brand_id"));
    mappingJacksonValue.setFilters(filterProvider);
    return new ResponseEntity(mappingJacksonValue, HttpStatus.OK);
  }
  @GetMapping({"{id}"})
  public ResponseEntity getCategoryById(@PathVariable int id){
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(categoryService.getCategoryById(id));
    FilterProvider filterProvider = new SimpleFilterProvider()
            .addFilter("filter.category", SimpleBeanPropertyFilter.serializeAllExcept())
            .addFilter("filter.product", SimpleBeanPropertyFilter.filterOutAllExcept("id","name","price","unit","stock","sku","description","review","rating","shop_id","brand_id"));
    mappingJacksonValue.setFilters(filterProvider);
    return new ResponseEntity(mappingJacksonValue, HttpStatus.OK);
  }
}
