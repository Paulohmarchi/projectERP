package br.faj.products.gateway.mongodb.entity;

import br.faj.products.domain.Feature;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "product")
public class ProductEntity {
    @Field(value = "id")
    private String id;
    @Field("name")
    private String name;
    @Field("price")
    private Double price;
    @Field("barcode")
    private String barcode;
    @Field("industrial")
    @DBRef
    private IndustrialEntity industrial;
    @Field("features")
    @DBRef
    private List<FeatureEntity> features;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public IndustrialEntity getIndustrial() {
        return industrial;
    }

    public void setIndustrial(IndustrialEntity industrial) {
        this.industrial = industrial;
    }

    public List<FeatureEntity> getFeatures() { return features; }

    public void setFeatures(List<FeatureEntity> features) { this.features = features;  }
}
