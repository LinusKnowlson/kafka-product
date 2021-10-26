package spring.cloud.kafka.product.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import spring.cloud.kafka.product.models.Product;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {
	//contact model assembler
    @Override
    public EntityModel<Product> toModel(Product product) {

        return EntityModel.of(product, 
                linkTo(methodOn(ProductController.class).one(product.getId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).all()).withRel("products"));
    }
}
