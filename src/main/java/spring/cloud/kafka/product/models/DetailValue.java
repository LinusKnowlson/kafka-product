package spring.cloud.kafka.product.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailValue 
{
	private Long id;
	private String description;
    private String comment;
    
    public DetailValue(String description, String comment) {
        this.description = description;
        this.comment = comment;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

}
