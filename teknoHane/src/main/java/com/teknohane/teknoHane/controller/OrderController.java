package com.teknohane.teknoHane.controller;

import com.teknohane.teknoHane.model.Users;
import com.teknohane.teknoHane.model.dto.OrderDTO;
import com.teknohane.teknoHane.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        OrderDTO order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/getOrdersByUserId")
    public ResponseEntity<List<OrderDTO>> getOrdersByUserId(Authentication authentication){
        Long userId = ((Users) authentication.getPrincipal()).getId();
        List<OrderDTO> orderList = orderService.getOrdersBYUserId(userId);
        return new ResponseEntity<>(orderList , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> createOrder(Authentication authentication, @RequestBody List<Long> productIds) {
        Long userId = ((Users) authentication.getPrincipal()).getId();
        OrderDTO createdOrder = orderService.createOrder(userId, productIds);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        OrderDTO updatedOrder = orderService.updateOrder(orderDTO, id);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        boolean result = orderService.deleteOrder(id);
        if (result) {
            return new ResponseEntity<>("Deleted" + id, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
