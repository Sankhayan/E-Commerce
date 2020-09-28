package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.CtsProduct;

@Repository
public interface ProductRepository extends JpaRepository<CtsProduct, String> {

	List<CtsProduct> findByTypeId(String id);
}
