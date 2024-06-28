package com.teknohane.teknoHane.service;

import com.teknohane.teknoHane.model.dto.OrderDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getOrdersBYUserId(Long userId);
    OrderDTO createOrder(Long userId, List<Long> productIds);
    OrderDTO updateOrder(OrderDTO orderDTO, Long id);
    boolean deleteOrder(Long id);
}
