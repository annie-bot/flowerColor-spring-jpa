package com.flowercolor.shop.services;

import com.flowercolor.shop.entities.Enterprise;
import com.flowercolor.shop.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository repository;

    public void create (Enterprise enterpriseDto){
        Enterprise enterprise = new Enterprise(enterpriseDto.getCnpj(), enterpriseDto.getFlowerColor(), enterpriseDto.getCep());
        this.repository.save(enterprise);
    }

    public List<Enterprise>list(){
        return this.repository.findAll();
    }

    public Enterprise findByID(Long id){
        return this.repository.findById(id).get();
    }

    public Enterprise update(Long id, Enterprise enterpriseDto){
        Enterprise enterprise = this.findByID(id);
        enterprise.setCnpj(enterpriseDto.getCnpj());
        enterprise.setFlowerColor(enterprise.getFlowerColor());
        enterprise.setCep(enterprise.getCep());
        this.repository.save(enterprise);
        return enterprise;
    }

    public void deleteById (Long id){
        this.repository.deleteById(id);
    }

}
