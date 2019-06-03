package br.faj.products.domain;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feature {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    @NotEmpty
    private String type;
    @JsonProperty("value")
    @NotEmpty
    private String value;
    @JsonProperty("products")
    @NotNull
    private Product products;

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

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}
