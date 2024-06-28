package com.teknohane.teknoHane.model.dto;

import com.teknohane.teknoHane.model.Order;
import com.teknohane.teknoHane.model.Products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDTO {

    private Long orderDetailId;
    private Long orderId;
    private Long productId;
    private int quantity;
    private double unitPrice;
}
