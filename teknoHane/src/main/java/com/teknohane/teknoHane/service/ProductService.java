package com.teknohane.teknoHane.service;

import com.teknohane.teknoHane.model.Category;
import com.teknohane.teknoHane.model.Products;
import com.teknohane.teknoHane.model.dto.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List <ProductDTO> getAllProduct();
    ProductDTO getProductById(Long id);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id , ProductDTO productDTO);
    boolean deleteProduct(Long id);
    List<ProductDTO> getAllProductsByCategoryId(Long categoryId);


}
