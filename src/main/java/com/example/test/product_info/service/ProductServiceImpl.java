package com.example.test.product_info.service;

import com.example.test.product_info.domain.Product;
import com.example.test.product_info.repository.ProductRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;
    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Product product;
        try {
            product = productRepository.findById(id).get();
        } catch (RuntimeException ex) {
            logger.warn(ex.getMessage());
            return null;
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList;
        try {
            productList = productRepository.findAllByOrderByIdAsc();
        } catch (RuntimeException ex) {
            logger.warn(ex.getMessage());
            return null;
        }
        return productList;
    }

    @Override
    public Product saveProduct(Product product) {
        Product savedProduct;
        try {
            savedProduct = productRepository.save(product);
        } catch (RuntimeException ex) {
            logger.warn(ex.getMessage());
            return null;
        }
        return savedProduct;
    }

    @Override
    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (RuntimeException ex) {
            logger.warn(ex.getMessage());
            return false;
        }
        return true;
    }
}
