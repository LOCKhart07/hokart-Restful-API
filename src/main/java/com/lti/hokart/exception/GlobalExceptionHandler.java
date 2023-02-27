package com.lti.hokart.exception;

import com.lti.hokart.model.Category;
import com.lti.hokart.model.Order;
import com.lti.hokart.model.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Product> handleProductNotFoundException(ProductNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("message", e.getMessage());
        return new ResponseEntity<>(null, httpHeaders, httpStatus);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Category> handleCategoryNotFoundException(CategoryNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("message", e.getMessage());
        return new ResponseEntity<>(null, httpHeaders, httpStatus);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Order> handleOrderNotFoundException(OrderNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("message", e.getMessage());
        return new ResponseEntity<>(null, httpHeaders, httpStatus);
    }


}
