package com.example.test.product_info.service;

import com.example.test.product_info.domain.Language;
import com.example.test.product_info.repository.LanguageRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    final LanguageRepository languageRepository;
    private static final Logger logger = LogManager.getLogger(LanguageServiceImpl.class);

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAllLanguages() {
        List<Language> languageList;
        try {
            languageList = languageRepository.findAll();
        } catch (RuntimeException ex) {
            logger.warn(ex.getMessage());
            return null;
        }
        return languageList;
    }
}
