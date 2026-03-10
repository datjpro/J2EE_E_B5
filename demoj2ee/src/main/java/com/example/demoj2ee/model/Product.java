package com.example.demoj2ee.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

  @Id
  private String id;

  private String name;

  private long price;

  protected Product() {
    // for MongoDB mapping
  }

  public Product(String name, long price) {
    this.name = name;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public long getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(long price) {
    this.price = price;
  }
}
