package com.teknohane.teknoHane.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orderDetails")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long orderDetailId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH , CascadeType.DETACH}, targetEntity = Order.class)
    @JoinColumn(name = "order_id", insertable = false , updatable = false)
    private Order order;

    @Column(name = "order_id")
    private Long orderId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH , CascadeType.DETACH}, targetEntity = Products.class)
    @JoinColumn(name = "product_id", insertable = false , updatable = false)
    private Products product;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private double unitPrice;

}
