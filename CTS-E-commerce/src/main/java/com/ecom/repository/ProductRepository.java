package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.EcomProduct;

@Repository
public interface ProductRepository extends JpaRepository<EcomProduct, String> {

	List<EcomProduct> findByTypeId(String id);
}
