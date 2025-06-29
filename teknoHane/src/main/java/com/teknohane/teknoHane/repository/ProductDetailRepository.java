package com.teknohane.teknoHane.repository;

import com.teknohane.teknoHane.model.ProductsDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductsDetail, Long> {

    @Query(value =  "SELECT * FROM product_details  WHERE product_id = :productId", nativeQuery = true)
    List<ProductsDetail> productsDetailByProductId (@Param("productId")Long productId);
}
