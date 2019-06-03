package br.faj.products.domain;

import br.faj.products.gateway.mongodb.entity.FeatureEntity;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

@Component
public class FeatureMapper {

    public Feature mapParaDomain(FeatureEntity featureEntity){
        ModelMapper model = new ModelMapper();
        return model.map(featureEntity,Feature.class);
    }

    public FeatureEntity mapParaEntityn(Feature feature){
        ModelMapper model = new ModelMapper();
        return model.map(feature,FeatureEntity.class);
    }
}
