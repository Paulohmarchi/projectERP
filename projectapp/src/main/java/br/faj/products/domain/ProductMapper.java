package br.faj.products.domain;

import br.faj.products.gateway.mongodb.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product mapParaDomain(ProductEntity productEntity){
        ModelMapper model = new ModelMapper();
        return model.map(productEntity,Product.class);
    }

    public ProductEntity mapParaEntityn(Product product){
        ModelMapper model = new ModelMapper();
        return model.map(product,ProductEntity.class);
    }

}
