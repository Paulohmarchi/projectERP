package br.faj.products.gateway.mongodb.entity;


import br.faj.products.domain.Product;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "product")
public class FeatureEntity {

    @Field(value = "id")
    private String id;
    @Field("type")
    private String type;
    @Field("value")
    private String value;
    @Field("features")
    @DBRef
    private ProductEntity product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setProduct(ProductEntity product) {  this.product = product;  }

    public ProductEntity getProduct() { return product;   }
}
