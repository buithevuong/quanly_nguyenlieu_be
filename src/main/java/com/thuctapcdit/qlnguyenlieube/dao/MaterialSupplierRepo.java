package com.thuctapcdit.qlnguyenlieube.dao;

import java.util.List;

import com.thuctapcdit.qlnguyenlieube.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thuctapcdit.qlnguyenlieube.model.Material;
import com.thuctapcdit.qlnguyenlieube.model.MaterialSupplier;

public interface MaterialSupplierRepo extends JpaRepository<MaterialSupplier, Long>{

	List<MaterialSupplier> findByMaterial(Material material);

	MaterialSupplier findByMaterialAndSupplier(Material material , Supplier supplier);
}
