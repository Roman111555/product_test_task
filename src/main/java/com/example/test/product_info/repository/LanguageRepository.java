package com.example.test.product_info.repository;

import com.example.test.product_info.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
