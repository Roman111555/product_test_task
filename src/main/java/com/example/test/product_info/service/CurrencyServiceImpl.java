package com.example.test.product_info.service;

import com.example.test.product_info.domain.Currency;
import com.example.test.product_info.repository.CurrencyRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    final CurrencyRepository currencyRepository;
    private static final Logger logger = LogManager.getLogger(CurrencyServiceImpl.class);

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<Currency> getAllCurrencies() {
        List<Currency> currencyList;
        try {
            currencyList = currencyRepository.findAll();
        } catch (RuntimeException ex) {
            logger.warn(ex.getMessage());
            return null;
        }
        return currencyList;
    }
}
