package com.example.demoj2ee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demoj2ee.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {}
