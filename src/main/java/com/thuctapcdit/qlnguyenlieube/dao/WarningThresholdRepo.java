package com.thuctapcdit.qlnguyenlieube.dao;

import com.thuctapcdit.qlnguyenlieube.model.WarningThreshold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WarningThresholdRepo extends JpaRepository<WarningThreshold , Long > {


    Optional<WarningThreshold> findById(Long aLong);

    Optional<WarningThreshold> findByThreshold(Float threshold);

}
