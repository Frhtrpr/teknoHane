package com.teknohane.teknoHane.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "carts")
@RequiredArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "user_id", insertable = false , updatable = false)
    private Users user;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(targetEntity = Products.class)
    @JoinColumn(name = "product_id", insertable = false , updatable = false)
    private Products product;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "created_at")
    private Date createdAt;

}
