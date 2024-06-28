package com.teknohane.teknoHane.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private Long orderId;
    private Long userId;
    private List<Long> productIds;
    private Date orderDate;
    private Date deliveryDate;

    private double totalAmount;
    private String status;
}
