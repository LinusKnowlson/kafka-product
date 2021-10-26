package spring.cloud.kafka.product.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import spring.cloud.kafka.product.controllers.ProductDetailModelAssembler;
import spring.cloud.kafka.product.controllers.ProductDetailNotFoundException;
import spring.cloud.kafka.product.models.ProductDetail;
import spring.cloud.kafka.product.repositories.ProductDetailRepository;

@Service
public class ProductDetailService implements ProductDetailIF
{
	//product detail repository and assembler
	private final ProductDetailRepository repository;
    private final ProductDetailModelAssembler assembler;
    //constructor
    ProductDetailService(ProductDetailRepository repository, ProductDetailModelAssembler assembler) 
    {
        this.repository = repository;
        this.assembler = assembler;
    }
    //load all the details
	@Override
	public CollectionModel<EntityModel<ProductDetail>> all() {
		// TODO Auto-generated method stub
		List<EntityModel<ProductDetail>> details = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(details, linkTo(methodOn(ProductDetailService.class).all()).withSelfRel());
	}
	//create new product detail
	@Override
	public ResponseEntity<?> newDetail(ProductDetail newProductDetail) {
		// TODO Auto-generated method stub
		EntityModel<ProductDetail> entityModel = assembler.toModel(repository.save(newProductDetail));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
	}
	//find detail by id
	@Override
	public EntityModel<ProductDetail> one(Long id) {
		// TODO Auto-generated method stub
		 ProductDetail productDetail = repository.findById(id).orElseThrow(() -> new ProductDetailNotFoundException(id));
	        return assembler.toModel(productDetail);
	}
	//update product detail
	@Override
	public ResponseEntity<?> replaceDetail(ProductDetail newProductDetail, Long id) {
		// TODO Auto-generated method stub
		ProductDetail updatedProductDetail = repository.findById(id) 
                .map(detail -> {
                    detail.setDescription(newProductDetail.getDescription());
                    detail.setComment(newProductDetail.getComment());
                    return repository.save(detail);
                }) 
                .orElseGet(() -> {
                    newProductDetail.setId(id);
                    return repository.save(newProductDetail);
                });
        EntityModel<ProductDetail> entityModel = assembler.toModel(updatedProductDetail);
        return ResponseEntity 
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
	}
	//delete product detail by id
	@Override
	public ResponseEntity<?> deleteDetail(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
        return ResponseEntity.noContent().build();
	}
}
