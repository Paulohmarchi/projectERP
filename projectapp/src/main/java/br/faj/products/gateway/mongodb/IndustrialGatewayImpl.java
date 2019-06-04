package br.faj.products.gateway.mongodb;

import br.faj.products.domain.Industrial;
import br.faj.products.domain.IndustrialMapper;
import br.faj.products.gateway.IndustrialGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IndustrialGatewayImpl implements IndustrialGateway {

    private final IndustrialRepository industrialRepository;
    private final IndustrialMapper industrialMapper;

    @Autowired
    public IndustrialGatewayImpl(IndustrialRepository industrialRepository, IndustrialMapper industrialMapper) {
        this.industrialRepository = industrialRepository;
        this.industrialMapper = industrialMapper;
    }

    @Override
    public Industrial findById(String id) {
        return industrialMapper.mapParaDomain(industrialRepository.findById(id));
    }

    @Override
    public Industrial findByCnpj(String cnpj) {
        return industrialMapper.mapParaDomain(industrialRepository.findByCnpj(cnpj));
    }

    @Override
    public Industrial findByName(String name) {
        return industrialMapper.mapParaDomain(industrialRepository.findByName(name));
    }

    @Override
    public Industrial findBySocialReason(String socialReason) {
        return industrialMapper.mapParaDomain(industrialRepository.findBySocialReason(socialReason));
    }

    @Override
    public Industrial findByTelephone(String telephone) {
        return industrialMapper.mapParaDomain(industrialRepository.findByTelephone(telephone));
    }

    @Override
    public Industrial findByCellphone(String cellphone) {
        return industrialMapper.mapParaDomain(industrialRepository.findByCellphone(cellphone));
    }

    @Override
    public Industrial findByAddress1(String address1) {
        return industrialMapper.mapParaDomain(industrialRepository.findByAddress1(address1));
    }

    @Override
    public Industrial findByAddress2(String address2) {
        return industrialMapper.mapParaDomain(industrialRepository.findByAddress2(address2));
    }

    @Override
    public Industrial findByCep(String cep) {
        return industrialMapper.mapParaDomain(industrialRepository.findByCep(cep));
    }

    @Override
    public Industrial findByEmail(String email) {
        return industrialMapper.mapParaDomain(industrialRepository.findByEmail(email));
    }

    @Override
    public List<Industrial> findAll() {
        return industrialRepository.findAll().stream().map(industrialMapper::mapParaDomain).collect(Collectors.toList());
    }

    @Override
    public Industrial save(Industrial industrialSave) {
        return industrialMapper.mapParaDomain(industrialRepository.save(industrialMapper.mapParaEntityn(industrialSave)));
    }
}
