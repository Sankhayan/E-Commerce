package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.*;

@Repository
public interface CartRepository extends JpaRepository<CtsCart, Long> {
	List<CtsCart> findByUserId(String userId);
}
