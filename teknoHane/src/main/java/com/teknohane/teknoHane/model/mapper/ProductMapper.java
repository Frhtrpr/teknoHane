package com.teknohane.teknoHane.model.mapper;

import com.teknohane.teknoHane.model.Products;
import com.teknohane.teknoHane.model.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public static ProductDTO toDTO(Products products){
        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId(products.getProductId());
        productDTO.setProductName(products.getProductName());
        productDTO.setDescription(products.getDescription());
        productDTO.setCategoryId(products.getCategoryId());
        productDTO.setPrice(products.getPrice());
        productDTO.setProductInfo(products.getProductInfo());
        productDTO.setStockQuantity(products.getStockQuantity());
        productDTO.setProductImages(products.getProductImages());
        return productDTO;
    }

    public static Products toEntity(ProductDTO productDTO){
        Products products = new Products();

        products.setProductId(productDTO.getProductId());
        products.setProductName(productDTO.getProductName());
        products.setDescription(productDTO.getDescription());
        products.setCategoryId(productDTO.getCategoryId());
        products.setPrice(productDTO.getPrice());
        products.setProductInfo(productDTO.getProductInfo());
        products.setStockQuantity(productDTO.getStockQuantity());
        products.setProductImages(productDTO.getProductImages());
        return products;
    }

}
