package com.teknohane.teknoHane.repository;

import com.teknohane.teknoHane.model.Products;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository <Products , Long> {

    @Query(value =  "SELECT * FROM products  WHERE category_id = :categoryId", nativeQuery = true)
    List<Products> productByCategoryId (@Param("categoryId")Long categoryId);

}
