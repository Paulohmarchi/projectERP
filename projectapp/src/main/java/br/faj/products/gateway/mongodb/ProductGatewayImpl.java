package br.faj.products.gateway.mongodb;

import br.faj.products.domain.Product;
import br.faj.products.domain.ProductMapper;
import br.faj.products.gateway.ProductGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductGatewayImpl implements ProductGateway {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductGatewayImpl(ProductRepository productRepository,ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public Product findById(String id) {
        return productMapper.mapParaDomain(productRepository.findById(id));
    }

    @Override
    public Product findByName(String name) {
        return productMapper.mapParaDomain(productRepository.findByName(name));
    }

    @Override
    public Product findByPrice(Double price) {
        return productMapper.mapParaDomain(productRepository.findByPrice(price));
    }

    @Override
    public Product findByBarcode(String barcode) {
        return productMapper.mapParaDomain(productRepository.findByBarcode(barcode));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(productMapper::mapParaDomain).collect(Collectors.toList());
    }

    @Override
    public Product save(Product productSave) {
        return productMapper.mapParaDomain(productRepository.save(productMapper.mapParaEntityn(productSave)));
    }
}
