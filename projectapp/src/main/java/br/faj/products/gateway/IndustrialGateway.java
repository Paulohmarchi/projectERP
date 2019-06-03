package br.faj.products.gateway;

import br.faj.products.domain.Industrial;

import java.util.List;

public interface IndustrialGateway {

    Industrial findById(String id);
    Industrial findByCnpj(String cnpj);
    Industrial findByName(String name);
    Industrial findBySocialReason(String socialReason);
    Industrial findByTelephone(String telephone);
    Industrial findByCellphone(String cellphone);
    Industrial findByAddress1(String address1);
    Industrial findByAddress2(String address2);
    Industrial findByCep(String cep);
    Industrial findByEmail(String email);
    List<Industrial> findAll();

    Industrial save (Industrial industrialSave);
}
