package com.sun.chau.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImageModel {
  private String name;
  private long size;
  private String format;
  private String base64String;

  public String generateNameByNanoTime(){
    this.name = System.nanoTime() + "." + this.format;
    return this.name;
  }

  public ImageModel(String name, long size, String format, String base64String) {
    this.name = name;
    this.size = size;
    this.format = format;
    this.base64String = base64String;
  }
}
