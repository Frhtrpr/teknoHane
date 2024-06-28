package com.teknohane.teknoHane.service;

import com.teknohane.teknoHane.model.dto.ProductDetailDTO;

import java.util.List;

public interface ProductDetailService {

    List<ProductDetailDTO> getAllProductDetail();
    ProductDetailDTO getProductDetailById(Long id);
    ProductDetailDTO getProductDetailByProductId(Long productId);
    ProductDetailDTO createProductDetail(ProductDetailDTO productDetailDTO);
    ProductDetailDTO updateProductDetail (ProductDetailDTO productDetailDTO , Long id);
    boolean deleteByDetailId(Long id);
}
