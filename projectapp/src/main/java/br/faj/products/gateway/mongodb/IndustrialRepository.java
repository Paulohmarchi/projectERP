package br.faj.products.gateway.mongodb;

import br.faj.products.gateway.mongodb.entity.IndustrialEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IndustrialRepository extends MongoRepository<IndustrialEntity, String> {

    IndustrialEntity findById(String id);
    IndustrialEntity findByCnpj(String cnpj);
    IndustrialEntity findByName(String name);
    IndustrialEntity findBySocialReason(String socialReason);
    IndustrialEntity findByTelephone(String telephone);
    IndustrialEntity findByCellphone(String cellphone);
    IndustrialEntity findByAddress1(String address1);
    IndustrialEntity findByAddress2(String address2);
    IndustrialEntity findByCep(String cep);
    IndustrialEntity findByEmail(String email);
    List<IndustrialEntity> findAll();

}
