package com.teknohane.teknoHane.model.mapper;

import com.teknohane.teknoHane.model.Products;
import com.teknohane.teknoHane.model.dto.ProductDTO;
import com.teknohane.teknoHane.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final UsersRepository userRepository;

    public ProductDTO toDTO(Products products) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId(products.getProductId());
        productDTO.setProductName(products.getProductName());
        productDTO.setDescription(products.getDescription());
        productDTO.setCategoryId(products.getCategoryId());
        productDTO.setPrice(products.getPrice());
        productDTO.setProductInfo(products.getProductInfo());
        productDTO.setStockQuantity(products.getStockQuantity());
        productDTO.setProductImages(products.getProductImages());

        if (products.getSellerId() != null) {
            userRepository.findById(products.getSellerId()).ifPresent(user -> {
                String fullName = user.getFirstName() + " " + user.getLastName();
                productDTO.setSellerName(fullName);
            });
        }

        return productDTO;
    }

    public Products toEntity(ProductDTO productDTO) {
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
