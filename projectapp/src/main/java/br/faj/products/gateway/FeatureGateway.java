package br.faj.products.gateway;

import br.faj.products.domain.Feature;
import br.faj.products.domain.Product;


import java.util.List;

public interface FeatureGateway {

    Feature getById(String id);
    Feature findByValue(String value);
    Feature findByType(String type);
    Feature findByProduct(List<Product> product);
    List<Feature> findAll();

}
