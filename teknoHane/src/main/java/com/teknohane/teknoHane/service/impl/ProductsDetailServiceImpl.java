package com.teknohane.teknoHane.service.impl;

import com.teknohane.teknoHane.model.ProductsDetail;
import com.teknohane.teknoHane.model.dto.ProductDetailDTO;
import com.teknohane.teknoHane.model.mapper.ProductDetailMapper;
import com.teknohane.teknoHane.repository.ProductDetailRepository;
import com.teknohane.teknoHane.service.ProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsDetailServiceImpl implements ProductDetailService {


    private final ProductDetailRepository productDetailRepository;
    @Override
    public List<ProductDetailDTO> getAllProductDetail() {
        List<ProductsDetail> productDetailList = productDetailRepository.findAll();
        return productDetailList.stream().map(ProductDetailMapper :: toDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDetailDTO getProductDetailById(Long id) {
        ProductsDetail productDetail = productDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return ProductDetailMapper.toDTO(productDetail);
    }

    @Override
    public ProductDetailDTO getProductDetailByProductId(Long productId) {
        List<ProductsDetail> productDetails = productDetailRepository.productsDetailByProductId(productId);
        if (productDetails.isEmpty()) {
            throw new RuntimeException("Product details not found for product id: " + productId);
        }

        ProductsDetail productDetail = productDetails.get(0);
        return ProductDetailMapper.toDTO(productDetail);
    }


    @Override
    public ProductDetailDTO createProductDetail(ProductDetailDTO productDetailDTO) {
        ProductsDetail saveProduct = ProductDetailMapper.toEntity(productDetailDTO);
        saveProduct = productDetailRepository.save(saveProduct);
        return ProductDetailMapper.toDTO(saveProduct);
    }

    @Override
    public ProductDetailDTO updateProductDetail(ProductDetailDTO productDetailDTO, Long id) {
        ProductsDetail existingProductDetail = productDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Products detail not found with id: " + id));
        ProductsDetail updateProductDetail = ProductDetailMapper.toEntity(productDetailDTO);
        updateProductDetail.setProductdetailId(existingProductDetail.getProductdetailId());
        updateProductDetail = productDetailRepository.save(updateProductDetail);
        return ProductDetailMapper.toDTO(updateProductDetail);
    }

    @Override
    public boolean deleteByDetailId(Long id) {
        if (!productDetailRepository.existsById(id)) {
            return false;
        }
        productDetailRepository.deleteById(id);
        return true;
    }
}

