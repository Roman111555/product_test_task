package com.example.test.product_info.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriceValidation.class)
public @interface Price {

    String message() default "Age should be more then zero!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
