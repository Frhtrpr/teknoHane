package com.teknohane.teknoHane.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "product_details")
public class ProductsDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_detail_id")
    private Long productdetailId;

    @OneToOne(fetch = FetchType.EAGER , targetEntity = Products.class)
    @JoinColumn(name = "product_id" , insertable = false , updatable = false)
    private Products product;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "features", columnDefinition = "TEXT")
    private String features;

    @Column(name = "technical_details", columnDefinition = "TEXT")
    private String technicalDetails;

}
