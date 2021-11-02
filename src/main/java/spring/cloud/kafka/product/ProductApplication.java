package spring.cloud.kafka.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.stream.function.StreamBridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import spring.cloud.kafka.product.models.Product;

import java.util.function.Consumer;

@SpringBootApplication
public class ProductApplication {

	private static final Logger log = LoggerFactory.getLogger(ProductApplication.class);
	//url to get info of a product from localhost
	private static final String url = "http://localhost:8081/products/2"; 
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public Consumer<Product> consume() {
		return input -> log.info(input.toString());
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate, StreamBridge streamBridge) throws Exception {
		return args -> {
			Product product = restTemplate.getForObject(url, Product.class);
			if(product != null) {
				log.info(product.toString());
			}
		};
	}

}
