package br.faj.products.gateway.mongodb;

import br.faj.products.gateway.mongodb.entity.FeatureEntity;

import br.faj.products.gateway.mongodb.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface FeatureRepository extends MongoRepository<FeatureEntity, String> {

    FeatureEntity findById(String id);
    FeatureEntity findByValue(String value);
    FeatureEntity findByType(String type);
    FeatureEntity findByProduct(List<ProductEntity> product);
    List<FeatureEntity> findAll();

}
