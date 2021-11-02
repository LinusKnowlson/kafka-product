package spring.cloud.kafka.product.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product 
{
	@Id
    @GeneratedValue
    private Long id;
    private String productCategory;
    private String name;
    private double price;
    private int stockQuantity;
    private Long detail;
    
    public Product() {}

    public Product(String productCategory, String name, double price, int stockQuantity, Long detail) {
        this.productCategory = productCategory;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.detail = detail;
    }
    //accessors and mutators of the product
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public Long getDetail() {
		return detail;
	}
    
    public void setDetail(Long detail) {
		this.detail = detail;
	}
    
	//retrive all the information of the product
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCategory='" + productCategory + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", stockQuantity='" + stockQuantity + '\'' +
                ", productDetail='" + detail + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(this.id, product.id)
                && Objects.equals(this.productCategory, product.productCategory)
                && Objects.equals(this.name, product.name)
                && Objects.equals(this.stockQuantity, product.stockQuantity)
                && Objects.equals(this.price, product.price)
                && Objects.equals(this.detail, product.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.productCategory, this.name, this.price, this.stockQuantity, this.detail);
    }
}
