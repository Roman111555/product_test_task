package com.example.test.product_info.controller;

import com.example.test.product_info.domain.Currency;
import com.example.test.product_info.domain.Language;
import com.example.test.product_info.domain.Product;
import com.example.test.product_info.service.CurrencyService;
import com.example.test.product_info.service.LanguageService;
import com.example.test.product_info.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product/")
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;
    private final LanguageService languageService;
    private final CurrencyService currencyService;

    @Autowired
    public ProductControllerImpl(ProductService productService, LanguageService languageService, CurrencyService currencyService) {
        this.productService = productService;
        this.languageService = languageService;
        this.currencyService = currencyService;
    }

    @Override
    public ResponseEntity<Product> getById(Long id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> allProducts = productService.getAllProducts();
        if (allProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> createProduct(Product product) {

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product savedProduct = productService.saveProduct(product);
        if (savedProduct == null) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Product product) {
        Product savedProduct;

        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
        Product productById = productService.getProductById(product.getId());
        if (productById != null) {
            savedProduct = productService.saveProduct(product);
            if (savedProduct == null) {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> updateProductById(Product productById, Product product) {
        if (product == null && productById == null) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
        BeanUtils.copyProperties(product, productById, "id");
        Product savedProduct = productService.saveProduct(productById);
        if (savedProduct == null) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteProduct(Long id) {
        if (id == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        boolean status = productService.deleteProduct(id);
        if (!status)
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Language>> getAllLanguages() {
        List<Language> allLanguages = languageService.getAllLanguages();
        if (allLanguages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allLanguages, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        List<Currency> allCurrencies = currencyService.getAllCurrencies();
        if (allCurrencies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allCurrencies, HttpStatus.OK);
    }
}
