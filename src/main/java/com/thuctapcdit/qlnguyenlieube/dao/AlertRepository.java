package com.thuctapcdit.qlnguyenlieube.dao;

import com.thuctapcdit.qlnguyenlieube.model.Alert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert , Long > {

    Page<Alert> findAllByOrderByCreatedAtDesc(Pageable pageable);

    Long countByIsChecked(Integer isChecked);

    List<Alert> findAllByIsChecked(Integer isChecked);
}
