package spring.cloud.kafka.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.cloud.kafka.product.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{}
