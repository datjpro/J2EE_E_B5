package com.example.demoj2ee.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Document(collection = "products")
public class Product {

  @Id
  private String id;

  @NotBlank(message = "Ten san pham khong duoc de trong")
  @Size(min = 2, max = 120, message = "Ten san pham phai tu 2 den 120 ky tu")
  private String name;

  @NotNull(message = "Gia khong duoc de trong")
  @Positive(message = "Gia phai lon hon 0")
  private Long price;

  @NotBlank(message = "Danh muc khong duoc de trong")
  private String categoryId;

  @NotBlank(message = "Hinh anh khong duoc de trong")
  @Size(max = 500, message = "Duong dan hinh anh toi da 500 ky tu")
  private String imageUrl;

  @Transient
  private Double discountedPrice;

  public Product() {
    // for MongoDB mapping
  }

  public Product(String name, Long price, String categoryId, String imageUrl) {
    this.name = name;
    this.price = price;
    this.categoryId = categoryId;
    this.imageUrl = imageUrl;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getPrice() {
    return price;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public Double getDiscountedPrice() {
    return discountedPrice;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public void setDiscountedPrice(Double discountedPrice) {
    this.discountedPrice = discountedPrice;
  }
}
