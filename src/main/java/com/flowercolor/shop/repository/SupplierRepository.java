package com.flowercolor.shop.repository;

import com.flowercolor.shop.entities.Enterprise;
import com.flowercolor.shop.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findByCpf(String cpf);
    Optional<Supplier> findByCnpj(String cnpj);
    Optional <List<Supplier>> findAllByNameContainingIgnoreCase(String search);
    Optional <List<Supplier>> findAllByCpfContainingIgnoreCase(String search);
    Optional <List<Supplier>> findAllByCnpjContainingIgnoreCase(String search);
}
