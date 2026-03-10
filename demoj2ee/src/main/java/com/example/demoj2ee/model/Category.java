package com.example.demoj2ee.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document(collection = "categories")
public class Category {

  @Id
  private String id;

  @NotBlank(message = "Ten danh muc khong duoc de trong")
  @Size(min = 2, max = 80, message = "Ten danh muc phai tu 2 den 80 ky tu")
  private String name;

  public Category() {
    // for MongoDB mapping
  }

  public Category(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
