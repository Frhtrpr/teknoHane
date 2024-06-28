package com.teknohane.teknoHane.model.mapper;

import com.teknohane.teknoHane.model.OrderDetail;
import com.teknohane.teknoHane.model.dto.OrderDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {

    public static OrderDetailDTO toDTO(OrderDetail orderDetail){
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();

        orderDetailDTO.setOrderDetailId(orderDetail.getOrderDetailId());
        orderDetailDTO.setProductId(orderDetail.getProductId());
        orderDetailDTO.setOrderId(orderDetail.getOrderId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        orderDetailDTO.setUnitPrice(orderDetail.getUnitPrice());
        return orderDetailDTO;
    }

    public static OrderDetail toEntity(OrderDetailDTO orderDetailDTO){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderDetailId(orderDetailDTO.getOrderDetailId());
        orderDetail.setProductId(orderDetailDTO.getProductId());
        orderDetail.setOrderId(orderDetailDTO.getOrderId());
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        orderDetail.setUnitPrice(orderDetailDTO.getUnitPrice());
        return orderDetail;
    }

}
