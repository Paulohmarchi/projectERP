package br.faj.products.gateway;

import br.faj.products.domain.Product;

import java.util.List;

public interface ProductGateway {

    Product findById(String id);
    Product findByName(String name);
    Product findByPrice(Double price);
    Product findByBarcode(String barcode);
    List<Product> findAll();

}
