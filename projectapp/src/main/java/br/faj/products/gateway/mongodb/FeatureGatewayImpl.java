package br.faj.products.gateway.mongodb;

import br.faj.products.domain.Feature;
import br.faj.products.domain.Product;
import br.faj.products.domain.FeatureMapper;
import br.faj.products.gateway.FeatureGateway;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FeatureGatewayImpl implements FeatureGateway {

    private final FeatureRepository featureRepository;
    private final FeatureMapper featureMapper;

    public FeatureGatewayImpl(FeatureRepository featureRepository, FeatureMapper featureMapper) {
        this.featureRepository = featureRepository;
        this.featureMapper = featureMapper;
    }


    @Override
    public Feature getById(String id) {

        return featureMapper.mapParaDomain(featureRepository.findById(id));
    }

    @Override
    public Feature findByValue(String value) {
        return featureMapper.mapParaDomain(featureRepository.findByValue(value));
    }

    @Override
    public Feature findByType(String type) {

        return featureMapper.mapParaDomain(featureRepository.findByType(type));
    }

    @Override
    public List<Feature> findAll() {
        return featureRepository.findAll().stream().map(featureMapper::mapParaDomain).collect(Collectors.toList());
    }

    @Override
    public Feature save(Feature featureSave) {
        return featureMapper.mapParaDomain(featureRepository.save(featureMapper.mapParaEntityn(featureSave)));
    }
}
