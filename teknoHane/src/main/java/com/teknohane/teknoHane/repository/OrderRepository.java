package com.teknohane.teknoHane.repository;

import com.teknohane.teknoHane.model.Cart;
import com.teknohane.teknoHane.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order , Long> {

    @Query(value =  "SELECT * FROM orders  WHERE user_id = :userId", nativeQuery = true)
    List<Order> getOrdersByUserId (@Param("userId")Long userId);
}
