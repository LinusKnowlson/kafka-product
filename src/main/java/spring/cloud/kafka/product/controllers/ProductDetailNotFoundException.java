package spring.cloud.kafka.product.controllers;

@SuppressWarnings("serial")
public class ProductDetailNotFoundException extends RuntimeException {

    public ProductDetailNotFoundException(Long id) {
        super("Could not find product details " + id);
    }
}