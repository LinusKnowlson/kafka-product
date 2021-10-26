package spring.cloud.kafka.product.services;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import spring.cloud.kafka.product.models.Product;

public interface ProductServiceIF //interface for product service
{
	public abstract CollectionModel<EntityModel<Product>> all();
	public abstract Product newProduct(Product newProduct);
	public abstract EntityModel<Product> one(Long id);
	public abstract Product replaceProduct(Product newProduct,Long id);
	public abstract void deleteProduct(Long id);
}
