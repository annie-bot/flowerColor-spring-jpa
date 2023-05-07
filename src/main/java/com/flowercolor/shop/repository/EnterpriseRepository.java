package com.flowercolor.shop.repository;

import com.flowercolor.shop.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnterpriseRepository extends JpaRepository <Enterprise, Long> {
    Optional<Enterprise> findByCnpj(String cnpj);

}