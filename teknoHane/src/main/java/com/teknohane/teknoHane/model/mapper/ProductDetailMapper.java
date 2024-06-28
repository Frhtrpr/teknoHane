package com.teknohane.teknoHane.model.mapper;

import com.teknohane.teknoHane.model.ProductsDetail;
import com.teknohane.teknoHane.model.dto.ProductDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailMapper {

    public  static ProductDetailDTO toDTO (ProductsDetail productDetail){
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();

        productDetailDTO.setProductdetailId(productDetail.getProductdetailId());
        productDetailDTO.setProductId(productDetail.getProductId());
        productDetailDTO.setBrand(productDetail.getBrand());
        productDetailDTO.setModel(productDetail.getModel());
        productDetailDTO.setFeatures(productDetail.getFeatures());
        productDetailDTO.setTechnicalDetails(productDetail.getTechnicalDetails());

        return productDetailDTO;
    }

    public static ProductsDetail toEntity (ProductDetailDTO productDetailDTO) {
        ProductsDetail productDetail = new ProductsDetail();

        productDetail.setProductdetailId(productDetailDTO.getProductdetailId());
        productDetail.setProductId(productDetailDTO.getProductId());
        productDetail.setBrand(productDetailDTO.getBrand());
        productDetail.setModel(productDetailDTO.getModel());
        productDetail.setFeatures(productDetailDTO.getFeatures());
        productDetail.setTechnicalDetails(productDetailDTO.getTechnicalDetails());

        return productDetail;
    }

}
