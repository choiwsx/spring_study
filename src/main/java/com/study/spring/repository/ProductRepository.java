package com.study.spring.repository;

import com.study.spring.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findByQuery(String query);
}
