package com.teknohane.teknoHane.repository;

import com.teknohane.teknoHane.model.Favorites;
import com.teknohane.teknoHane.model.dto.FavoritesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FavoritesRepository extends JpaRepository <Favorites, Long> {

    @Query(value =  "SELECT * FROM teknoHane.favorites  WHERE user_id = :userId", nativeQuery = true)
    List<Favorites> findAllByUserId(@Param("userId") Long userId);

    @Modifying
    @Query(value = "DELETE FROM favorites WHERE product_id = :productId", nativeQuery = true)
    int deleteByProductId(@Param("productId") Long productId);

}
