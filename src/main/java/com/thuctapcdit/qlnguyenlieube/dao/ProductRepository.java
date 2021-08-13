package com.thuctapcdit.qlnguyenlieube.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thuctapcdit.qlnguyenlieube.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Page<Product> findByNameLike(String name , Pageable pageable);
}
