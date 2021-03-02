package com.example.test.product_info.controller;

import com.example.test.product_info.domain.Currency;
import com.example.test.product_info.domain.Language;
import com.example.test.product_info.domain.Product;
import com.example.test.product_info.page.ProductPage;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProductClientController {

    @GetMapping
    ResponseEntity<Page<Product>> getProductsByNameAndDesc(
            ProductPage productPage,
            @RequestParam String name,
            @RequestParam String desc,
            @RequestParam(name = "currency", required = true) Currency currencyId,
            @RequestParam(name = "lang", required = true) Language languageId);

    @GetMapping("/all")
    ResponseEntity<Page<Product>> getProductsByCurrencyAndLanguage(
            ProductPage productPage,
            @RequestParam(name = "currency", required = true) Currency currencyId,
            @RequestParam(name = "lang", required = true) Language languageId);

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductsById(
            @PathVariable("id") Long productId,
            @RequestParam(name = "currency", required = true) Currency currencyId,
            @RequestParam(name = "lang", required = true) Language languageId);
}
