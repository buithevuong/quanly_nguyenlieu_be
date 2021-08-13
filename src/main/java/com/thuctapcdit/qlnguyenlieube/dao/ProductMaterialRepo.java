package com.thuctapcdit.qlnguyenlieube.dao;

import com.thuctapcdit.qlnguyenlieube.model.Product;
import com.thuctapcdit.qlnguyenlieube.model.ProductMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductMaterialRepo extends JpaRepository<ProductMaterial , Long > {

    List<ProductMaterial> findByProduct(Product product);
}
