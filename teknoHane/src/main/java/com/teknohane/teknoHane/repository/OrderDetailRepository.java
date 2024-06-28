package com.teknohane.teknoHane.repository;

import com.teknohane.teknoHane.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository <OrderDetail , Long> {
}
