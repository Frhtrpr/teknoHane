package com.teknohane.teknoHane.service.impl;

import com.teknohane.teknoHane.model.Category;
import com.teknohane.teknoHane.model.Order;
import com.teknohane.teknoHane.model.Products;
import com.teknohane.teknoHane.model.dto.ProductDTO;
import com.teknohane.teknoHane.model.mapper.ProductMapper;
import com.teknohane.teknoHane.repository.OrderRepository;
import com.teknohane.teknoHane.repository.ProductsRepository;
import com.teknohane.teknoHane.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;
    private final OrderRepository orderRepository;
    @Override
    public List<ProductDTO> getAllProduct() {
        List<Products> product = productsRepository.findAll();
        return product.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Products products = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return ProductMapper.toDTO(products);
    }

    @Override
    public List<ProductDTO> getAllProductsByCategoryId(Long categoryId) {
        List<Products> products = productsRepository.productByCategoryId(categoryId);
        return products.stream().map(ProductMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Products products = ProductMapper.toEntity(productDTO);
        products = productsRepository.save(products);
        return ProductMapper.toDTO(products);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Products existingProduct = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        Products updatedproduct = ProductMapper.toEntity(productDTO);
        updatedproduct.setProductId(existingProduct.getProductId());
        updatedproduct = productsRepository.save(updatedproduct);
        return ProductMapper.toDTO(updatedproduct);
    }

    @Transactional
    public boolean deleteProduct(Long productId) {
        Products product = productsRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        // You need to remove associations first
        for (Order order : orderRepository.findAll()) {
            order.getProducts().remove(product);
            orderRepository.save(order);
        }

        productsRepository.deleteById(productId);
        return true;
    }





}
