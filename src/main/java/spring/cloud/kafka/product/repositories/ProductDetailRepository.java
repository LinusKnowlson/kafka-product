package spring.cloud.kafka.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.cloud.kafka.product.models.ProductDetail;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {}