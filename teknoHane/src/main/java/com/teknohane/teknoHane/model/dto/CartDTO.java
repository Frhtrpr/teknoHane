package com.teknohane.teknoHane.model.dto;

import com.teknohane.teknoHane.model.Products;
import com.teknohane.teknoHane.model.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
@Getter
@Setter
public class CartDTO {

    private Long cartId;
    private Long userId;
    private Long productId;
    private int quantity;
    private Double totalPrice;
    private Date createdAt;
}
