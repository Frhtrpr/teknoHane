package com.teknohane.teknoHane.service.impl;

import com.teknohane.teknoHane.model.Order;
import com.teknohane.teknoHane.model.Products;
import com.teknohane.teknoHane.model.Users;
import com.teknohane.teknoHane.model.dto.OrderDTO;
import com.teknohane.teknoHane.model.mapper.OrderMapper;
import com.teknohane.teknoHane.repository.OrderRepository;
import com.teknohane.teknoHane.repository.ProductsRepository;
import com.teknohane.teknoHane.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductsRepository productRepository;

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return OrderMapper.toDTO(order);
    }

    @Override
    public List<OrderDTO> getOrdersBYUserId(Long userId) {
        List<Order> orderListByUserId = orderRepository.getOrdersByUserId(userId);
        return  orderListByUserId.stream().map(OrderMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDTO createOrder(Long userId, List<Long> productIds) {
        List<Products> products = productRepository.findAllById(productIds);
        double totalAmount = products.stream().mapToDouble(Products::getPrice).sum();

        // Ürünlerin stoğunu güncelle
        for (Products product : products) {
            if (product.getStockQuantity() > 0) {
                product.setStockQuantity(product.getStockQuantity() - 1);
            } else {
                throw new RuntimeException("Product out of stock: " + product.getProductId());
            }
        }

        productRepository.saveAll(products); // Güncellenen ürün stoğunu kaydet

        Order order = new Order();
        order.setUserId(userId);
        order.setOrderDate(new Date());

        // Teslimat tarihini hesapla
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getOrderDate());
        calendar.add(Calendar.DAY_OF_YEAR, 3); // 3 gün ekle
        order.setDeliveryDate(calendar.getTime());

        order.setTotalAmount(totalAmount);
        order.setStatus("CREATED");

        order = orderRepository.save(order);

        Set<Products> productSet = new HashSet<>(products);
        order.setProducts(productSet.stream().collect(Collectors.toList()));

        Order savedOrder = orderRepository.save(order);

        // Teslimat tarihi geldiğinde durumu güncelle
        updateOrderStatusToDelivered(savedOrder);

        return OrderMapper.toDTO(savedOrder);
    }

    private void updateOrderStatusToDelivered(Order order) {
        // Simülasyon için doğrudan durumu güncelle
        Calendar calendar = Calendar.getInstance();
        if (calendar.getTime().after(order.getDeliveryDate())) {
            order.setStatus("DELIVERED");
            orderRepository.save(order);
        }
    }
    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO, Long id) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        Order updatedOrder = OrderMapper.toEntity(orderDTO);
        updatedOrder.setOrderId(existingOrder.getOrderId());
        updatedOrder = orderRepository.save(updatedOrder);
        return OrderMapper.toDTO(updatedOrder);
    }

    @Transactional
    @Override
    public boolean deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        // Clear the association with products
        order.getProducts().clear();
        orderRepository.save(order);

        // Now delete the order
        orderRepository.deleteById(id);
        return true;
    }

}
