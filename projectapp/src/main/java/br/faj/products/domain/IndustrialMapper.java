package br.faj.products.domain;

import br.faj.products.gateway.mongodb.entity.IndustrialEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class IndustrialMapper {

    public Industrial mapParaDomain(IndustrialEntity industrialEntity){
        ModelMapper model = new ModelMapper();
        return model.map(industrialEntity,Industrial.class);
    }

    public IndustrialEntity mapParaEntityn(Industrial industrial){
        ModelMapper model = new ModelMapper();
        return model.map(industrial,IndustrialEntity.class);
    }
}
