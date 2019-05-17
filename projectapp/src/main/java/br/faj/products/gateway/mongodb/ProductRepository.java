package br.faj.products.gateway.mongodb;

import br.faj.products.gateway.mongodb.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends MongoRepository<ProductEntity, String> {

    ProductEntity findById(String id);
    ProductEntity findByName(String name);
    ProductEntity findByPrice(Double price);
    ProductEntity findByBarcode(String barcode);
    List<ProductEntity> findAll();

}
