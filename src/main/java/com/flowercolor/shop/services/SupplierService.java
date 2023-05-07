package com.flowercolor.shop.services;

import com.flowercolor.shop.entities.Enterprise;
import com.flowercolor.shop.entities.Supplier;
import com.flowercolor.shop.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository repository;

    public void create (Supplier supplierDto) throws Exception {
        Supplier supplier = new Supplier(supplierDto.getcnpj(), supplierDto.getCpf(), supplierDto.getName(), supplierDto.getEmail(), supplierDto.getCep());
        if (repository.findByCpf(supplierDto.getCpf()).isPresent()){
            throw new Exception("CPF já existe!");
        }
        if (repository.findByCnpj(supplierDto.getcnpj()).isPresent()){
            throw new Exception("CNPJ já existe!");
        }
        if (supplierDto.isPessoaFisica()){
            supplier.setRg(supplierDto.getRg());
            supplier.setDataNascimento(supplierDto.getDataNascimento());

        }
        this.repository.save(supplier);
    }
    public List<Supplier> listAllByCpf(String search) {
        return this.repository.findAllByCpfContainingIgnoreCase(search).get();
    }
    public List<Supplier> listAllByCnpj(String search) {
        return this.repository.findAllByCnpjContainingIgnoreCase(search).get();
    }
    public Supplier findByID(Long id){
        return this.repository.findById(id).get();
    }

    public List<Supplier>list(){
        return this.repository.findAll();
    }

    public Supplier findById(Long id){
        return this.repository.findById(id).get();

    }

    public Supplier update(Long id, Supplier supplierDto){
        Supplier supplier = this.findById(id);
        supplier.setCnpj(supplierDto.getcnpj());
        supplier.setCpf(supplierDto.getCpf());
        supplier.setName(supplierDto.getName());
        supplier.setEmail(supplierDto.getEmail());
        supplier.setCep(supplierDto.getCep());
        this.repository.save(supplier);
        return supplier;

    }

    public void deleteById(Long id){
        this.repository.deleteById(id);

    }
}