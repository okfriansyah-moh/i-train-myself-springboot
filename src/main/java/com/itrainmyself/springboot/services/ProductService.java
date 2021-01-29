package com.itrainmyself.springboot.services;

import com.itrainmyself.springboot.entity.Product;
import com.itrainmyself.springboot.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        /**
         * Logic to get all bank data
         */
        return productRepository.findAll();
    }
}
