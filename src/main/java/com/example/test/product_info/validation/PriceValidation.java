package com.example.test.product_info.validation;

import com.example.test.product_info.domain.Product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriceValidation  implements ConstraintValidator<Price,Product> {

    @Override
    public boolean isValid(Product value, ConstraintValidatorContext context) {
        return !(value.getPrice() <= 0);
    }
}
