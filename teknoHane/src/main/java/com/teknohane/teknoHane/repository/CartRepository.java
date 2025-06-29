package com.teknohane.teknoHane.repository;

import com.teknohane.teknoHane.model.Cart;
import com.teknohane.teknoHane.model.Favorites;
import com.teknohane.teknoHane.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository <Cart , Long> {

    @Query(value =  "SELECT * FROM carts  WHERE user_id = :userId", nativeQuery = true)
    List<Cart> getCartByUserId (@Param("userId")Long userId);

    @Modifying
    @Query(value = "DELETE FROM carts WHERE product_id = :productId",nativeQuery = true)
    int deleteByProductId(@Param("productId") Long productId);
}
