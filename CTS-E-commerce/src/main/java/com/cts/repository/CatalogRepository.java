package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.*;

@Repository
public interface CatalogRepository extends JpaRepository<CtsCatalog, String> {

}
