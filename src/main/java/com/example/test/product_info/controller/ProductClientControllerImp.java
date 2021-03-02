package com.example.test.product_info.controller;

import com.example.test.product_info.domain.Currency;
import com.example.test.product_info.domain.Language;
import com.example.test.product_info.domain.Product;
import com.example.test.product_info.exeption.ProductNotFoundException;
import com.example.test.product_info.page.ProductPage;
import com.example.test.product_info.service.ProductClientService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product/client")
public class ProductClientControllerImp implements ProductClientController {

    private final ProductClientService productClientService;
    private static final Logger logger = LogManager.getLogger(ProductControllerImpl.class);

    public ProductClientControllerImp(ProductClientService productClientService) {
        this.productClientService = productClientService;
    }

    @Override
    public ResponseEntity<Page<Product>> getProductsByNameAndDesc(
            ProductPage productPage,
            String name,
            String desc,
            Currency currencyId,
            Language languageId) {

        Page<Product> productList = productClientService.getAllProductsByNameOrDescription(name, desc, currencyId, languageId, productPage);
        if(productList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(productList, HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<Page<Product>> getProductsByCurrencyAndLanguage(
            ProductPage productPage,
            Currency currencyId,
            Language languageId) {

        Page<Product> productList = productClientService.getAllProductsByCurrencyAndLanguage(currencyId, languageId, productPage);
        if (productList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> getProductsById(
            Long productId,
            Currency currencyId,
            Language languageId) {

        Product product = productClientService.getProductByIdCurrencyAndLanguage(productId, currencyId, languageId);
        if (product == null){
            String errorMessage = String.format("Product with productId = %d, currencyId = %d, languageId = %d not found",
                    productId, currencyId.getId(), languageId.getId());
            logger.warn(errorMessage);
            throw new ProductNotFoundException(errorMessage);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
