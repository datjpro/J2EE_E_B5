package com.example.demoj2ee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoj2ee.model.Product;
import com.example.demoj2ee.repository.ProductRepository;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Optional<Product> findById(String id) {
    return productRepository.findById(id);
  }

  public Product create(Product product) {
    return productRepository.save(product);
  }

  public Optional<Product> update(String id, Product input) {
    Optional<Product> existing = productRepository.findById(id);
    if (existing.isEmpty()) {
      return Optional.empty();
    }
    Product product = existing.get();
    product.setName(input.getName());
    product.setPrice(input.getPrice());
    return Optional.of(productRepository.save(product));
  }

  public boolean delete(String id) {
    if (!productRepository.existsById(id)) {
      return false;
    }
    productRepository.deleteById(id);
    return true;
  }
}
