package com.thuctapcdit.qlnguyenlieube.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thuctapcdit.qlnguyenlieube.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Page<Product> findByNameLikeOrderByUpdatedAtDesc(String name , Pageable pageable);


	Page<Product> findByNameLikeAndStatusOrderByUpdatedAtDesc(String name ,Integer status, Pageable pageable);
}
