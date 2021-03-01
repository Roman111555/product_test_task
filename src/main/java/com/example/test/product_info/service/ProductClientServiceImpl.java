package com.example.test.product_info.service;

import com.example.test.product_info.domain.Currency;
import com.example.test.product_info.domain.Language;
import com.example.test.product_info.domain.Product;
import com.example.test.product_info.page.ProductPage;
import com.example.test.product_info.repository.ProductRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductClientServiceImpl implements ProductClientService {

    final ProductRepository productRepository;
    final ProductPage defaultProductPage;
    private static final Logger logger = LogManager.getLogger(ProductClientServiceImpl.class);

    public ProductClientServiceImpl(ProductRepository productRepository, ProductPage productPage) {
        this.productRepository = productRepository;
        this.defaultProductPage = productPage;
    }

    @Override
    public Page<Product> getAllProductsByNameOrDescription(String name, String desc, Currency currency, Language lang, ProductPage productPage) {
        Page<Product> productList = null;
        try {
            Pageable page = getProductPage(productPage);
            productList = productRepository.findByProductNameIgnoreCaseAndDescriptionIgnoreCase(name, desc, currency, lang, page);
        } catch (RuntimeException ex) {
            logger.warn(ex.getMessage());
        }
        return productList;
    }

    @Override
    public Page<Product> getAllProductsByCurrencyAndLanguage(Currency currency, Language lang, ProductPage productPage) {
        Page<Product> productList = null;
        try {
            Pageable page = getProductPage(productPage);
            productList = productRepository.findByCurrencyAndLanguage(currency, lang, page);
        } catch (RuntimeException ex) {
            logger.warn(ex.getMessage());
        }
        return productList;
    }

    private Pageable getProductPage(ProductPage productPage) {
        Sort.Direction direction = Sort.Direction.valueOf(productPage.getSortDirection().toUpperCase());
        Sort sort = Sort.by(direction, productPage.getSortBy());
        Pageable page = PageRequest.of(productPage.getPageNumber(), productPage.getPageSize(), sort);
        return page;
    }

    @Override
    public Product getProductByIdCurrencyAndLanguage(Long id, Currency currency, Language lang) {
        Product product = null;
        try {
            product = productRepository.findByIdAndCurrencyAndLanguage(id, currency, lang);
        } catch (RuntimeException ex) {
            logger.warn(ex.getMessage());
        }
        return product;
    }
}
