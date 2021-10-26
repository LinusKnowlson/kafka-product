package spring.cloud.kafka.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import spring.cloud.kafka.product.models.Product;

import java.util.function.Consumer;

@SpringBootApplication
public class ProductApplication {

	private static final Logger log = LoggerFactory.getLogger(ProductApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	@Bean
	public Consumer<Product> consume() {
		return input -> log.info(input.toString());
	}

}
