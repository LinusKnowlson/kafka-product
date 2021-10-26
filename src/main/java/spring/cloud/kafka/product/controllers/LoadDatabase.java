package spring.cloud.kafka.product.controllers;

import spring.cloud.kafka.product.models.Product;
import spring.cloud.kafka.product.models.ProductDetail;
import spring.cloud.kafka.product.repositories.ProductDetailRepository;
import spring.cloud.kafka.product.repositories.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    //loading database with data
    @Bean
    CommandLineRunner initDB(ProductRepository productRepository, ProductDetailRepository productDetailRepository) {
        return args -> {
            log.info("Loading... " + productRepository.save(new Product("kitchen utensils","microwave",786.5,23)));
            log.info("Loading... " + productRepository.save(new Product("Other utility","microprocessor",300.25,5)));
            log.info("Loading... " + productRepository.save(new Product("Kitchen utility","dishwasher",850,17)));
            productDetailRepository.save(new ProductDetail("frequency of 2450 MHz (a wavelength of 12.24 cm)", "Nice microwave"));
            productDetailRepository.save(new ProductDetail("an integrated circuit that contains all the functions of a central processing unit of a computer", "Nice microprocessor"));
            productDetailRepository.save(new ProductDetail("wish dishes", "Nice dishwasher"));
            productDetailRepository.findAll().forEach(detail -> log.info("Preloaded " + detail));
        };
    }
}
