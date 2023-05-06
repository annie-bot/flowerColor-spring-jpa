package com.flowercolor.shop.repository;

import com.flowercolor.shop.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository <Enterprise, Long> {
}
