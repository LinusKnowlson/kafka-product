package spring.cloud.kafka.product.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductDetailNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ProductDetailNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String detailNotFoundHandler(ProductDetailNotFoundException ex) {
        return ex.getMessage();
    }
}