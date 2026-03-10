package com.example.demoj2ee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demoj2ee.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {}
