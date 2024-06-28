package com.teknohane.teknoHane.model.dto;

import com.teknohane.teknoHane.model.Products;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailDTO {

    private Long productdetailId;
    private Long productId;
    private String brand;
    private String model;
    private String features;
    private String technicalDetails;
}