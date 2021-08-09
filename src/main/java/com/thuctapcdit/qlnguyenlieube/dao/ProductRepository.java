package com.thuctapcdit.qlnguyenlieube.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thuctapcdit.qlnguyenlieube.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("SELECT e FROM Product e WHERE e.name = ?1 ORDER BY e.name DESC")
	List<Product> getProductByName(String name);
}
