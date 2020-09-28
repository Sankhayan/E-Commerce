package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.*;

@Repository
public interface TypeRepository extends JpaRepository<CtsType, String> {
	List<CtsType> findByCatalogId(String id);
}
