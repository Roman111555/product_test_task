package com.example.test.product_info.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ControllerHandleException {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> ProductNotFoundException(ProductNotFoundException ex) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }
}
