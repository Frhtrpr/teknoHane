package com.teknohane.teknoHane.service;

import com.teknohane.teknoHane.model.dto.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {

    List <OrderDetailDTO> getAllOrderDetail();
    OrderDetailDTO getOrderDetailById(Long id);
    OrderDetailDTO createOrderDetail(OrderDetailDTO orderDetailDTO);
    OrderDetailDTO updateOrderDetail (OrderDetailDTO orderDetailDTO , Long id);
    boolean deleteOrderDetail(Long id);
}
