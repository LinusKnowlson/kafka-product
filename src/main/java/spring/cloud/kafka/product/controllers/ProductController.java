package spring.cloud.kafka.product.controllers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import spring.cloud.kafka.product.models.Product;
import spring.cloud.kafka.product.services.ProductService;

@RestController
public class ProductController 
{
	@Autowired
	ProductService productService;
    
    //find all the products
    @GetMapping("/products")
    CollectionModel<EntityModel<Product>> all() {
    	return productService.all();
    }
    //create a new product
    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct) {
        return productService.newProduct(newProduct);
    }
    //find product information by id
    @GetMapping("/products/{id}")
    EntityModel<Product> one(@PathVariable Long id) {
        return productService.one(id);
    }
    //update product
    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct,@PathVariable Long id) {
        return productService.replaceProduct(newProduct, id);
    }
  	//delete product record
    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id) {
    	productService.deleteProduct(id);
    }
}
