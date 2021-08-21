package com.thuctapcdit.qlnguyenlieube.dao;

import com.thuctapcdit.qlnguyenlieube.model.Material;
import com.thuctapcdit.qlnguyenlieube.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findByName(String name);

    Page<Supplier> findByNameLikeAndPhoneLikeAndEmailLikeOrderByUpdatedAtDesc(String name , String phone ,String email, Pageable pageable);

    Page<Supplier> findByNameLikeAndPhoneLikeAndEmailLikeAndStatusOrderByUpdatedAtDesc(String name , String phone ,String email, Integer status, Pageable pageable);
}
