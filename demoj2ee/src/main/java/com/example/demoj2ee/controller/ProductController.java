package com.example.demoj2ee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoj2ee.model.Product;
import com.example.demoj2ee.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<Product> findAll() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable String id) {
    Optional<Product> product = productService.findById(id);
    return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody Product product) {
    Product saved = productService.create(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product input) {
    Optional<Product> updated = productService.update(id, input);
    return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    boolean removed = productService.delete(id);
    return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
  }
}
