package com.thuctapcdit.qlnguyenlieube.dao;

import com.thuctapcdit.qlnguyenlieube.model.Material;
import com.thuctapcdit.qlnguyenlieube.model.MaterialWarning;
import com.thuctapcdit.qlnguyenlieube.model.WarningThreshold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MaterialWarningRepo extends JpaRepository<MaterialWarning , Long > {

    Optional<MaterialWarning> findByMaterialAndWarningThreshold(Material material ,
                                                                WarningThreshold warningThreshold);

    List<MaterialWarning> findByMaterial(Material material);

    List<MaterialWarning> deleteByMaterial(Material material);

}
