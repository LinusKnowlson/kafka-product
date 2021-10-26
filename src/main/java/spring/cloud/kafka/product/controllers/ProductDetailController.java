package spring.cloud.kafka.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.cloud.kafka.product.models.ProductDetail;
import spring.cloud.kafka.product.services.ProductDetailService;

@RestController
public class ProductDetailController {
	
	@Autowired
	ProductDetailService productDetailService;
	//get all the details
    @GetMapping("/details")
    CollectionModel<EntityModel<ProductDetail>> all() 
    {
        return productDetailService.all();
    }
    //create new product detail
    @PostMapping("/details")
    ResponseEntity<?> newDetail(@RequestBody ProductDetail newProductDetail) {
        return productDetailService.newDetail(newProductDetail);
    }
    //find detail by id
    @GetMapping("/details/{id}")
    EntityModel<ProductDetail> one(@PathVariable Long id) 
    {
    	return productDetailService.one(id);
    }
    //update product detail
    @PutMapping("/details/{id}")
    ResponseEntity<?> replaceDetail(@RequestBody ProductDetail newProductDetail, @PathVariable Long id) 
    {
    	return productDetailService.replaceDetail(newProductDetail, id);
    }
    //delete product detail by id
    @DeleteMapping("/details/{id}")
    ResponseEntity<?> deleteDetail(@PathVariable Long id)
    {
        return productDetailService.deleteDetail(id);
    }
}