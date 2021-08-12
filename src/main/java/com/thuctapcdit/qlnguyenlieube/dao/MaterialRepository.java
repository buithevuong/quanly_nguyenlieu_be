package com.thuctapcdit.qlnguyenlieube.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thuctapcdit.qlnguyenlieube.model.Material;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long>{

    Page<Material> findByNameLikeAndTypeLikeOrderByUpdatedAtDesc(String name ,String type , Pageable pageable);
}
