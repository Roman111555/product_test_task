package com.example.test.product_info.service;

import com.example.test.product_info.domain.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product saveProduct(Product product);

    boolean deleteProduct(Long id);

}
