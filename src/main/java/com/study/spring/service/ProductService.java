package com.study.spring.service;


import com.study.spring.domain.Product;
import com.study.spring.domain.ProductGroup;
import com.study.spring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){ this.productRepository = productRepository;}

    public List<Product> search(final String query)
    {
        ProductGroup productGroup = new ProductGroup(productRepository.findByQuery(query));
        return productGroup.getList();
    }




}
