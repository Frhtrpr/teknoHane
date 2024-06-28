package com.teknohane.teknoHane.model.mapper;

import com.teknohane.teknoHane.model.Order;
import com.teknohane.teknoHane.model.Products;
import com.teknohane.teknoHane.model.dto.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public static OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setUserId(order.getUserId());
        orderDTO.setProductIds(order.getProducts().stream().map(Products::getProductId).collect(Collectors.toList()));
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotalAmount(order.getTotalAmount());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setDeliveryDate(order.getDeliveryDate());
        return orderDTO;
    }

    public static Order toEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setUserId(orderDTO.getUserId());
        // Note: You will need to fetch Products entities by their IDs and set them to the order
        order.setOrderDate(orderDTO.getOrderDate());
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setStatus(orderDTO.getStatus());
        order.setDeliveryDate(orderDTO.getDeliveryDate());
        return order;
    }
}
