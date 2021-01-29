package com.itrainmyself.springboot.controller;

import com.itrainmyself.springboot.entity.Product;
import com.itrainmyself.springboot.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        /**
         * Controller to get all product
         */
        return productService.getAllProduct();
    }
}
