package com.example.test.product_info.controller;

import com.example.test.product_info.domain.Currency;
import com.example.test.product_info.domain.Language;
import com.example.test.product_info.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface ProductController {

    @GetMapping("{id}")
    ResponseEntity<Product> getById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<Product>> getAllProducts();

    @PostMapping
    ResponseEntity<Product> createProduct(@Valid @RequestBody Product product);

    @PutMapping
    ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product);

    @PutMapping("{id}")
    ResponseEntity<Product> updateProductById(
            @PathVariable(name = "id") Product productById,
            @Valid @RequestBody Product product);

    @DeleteMapping("{id}")
    ResponseEntity deleteProduct(@PathVariable("id") Long id);

    @GetMapping("language")
    ResponseEntity<List<Language>> getAllLanguages();

    @GetMapping("currency")
    ResponseEntity<List<Currency>> getAllCurrencies();
}
