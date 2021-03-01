package com.example.test.product_info.service;

import com.example.test.product_info.domain.Currency;
import com.example.test.product_info.domain.Language;
import com.example.test.product_info.domain.Product;
import com.example.test.product_info.page.ProductPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductClientService {

    Page<Product> getAllProductsByNameOrDescription(String name, String desc, Currency currency, Language lang, ProductPage productPage);
    Page<Product> getAllProductsByCurrencyAndLanguage(Currency currency, Language lang, ProductPage productPage);
    Product getProductByIdCurrencyAndLanguage(Long id, Currency currency, Language lang);
}
