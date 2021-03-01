package com.example.test.product_info.repository;

import com.example.test.product_info.domain.Currency;
import com.example.test.product_info.domain.Language;
import com.example.test.product_info.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByIdAsc();

    @Query(value = "select p from Product p where (UPPER(p.productName) = UPPER(?1) or UPPER(p.description) = UPPER(?2)) and p.currency = ?3 and p.language = ?4")
    Page<Product> findByProductNameIgnoreCaseAndDescriptionIgnoreCase(
            String productName,
            String description,
            Currency currency,
            Language language,
            Pageable pageable);

    Page<Product> findByCurrencyAndLanguage(Currency currency, Language language, Pageable pageable );
    Product findByIdAndCurrencyAndLanguage(Long id, Currency currency, Language language);
}
