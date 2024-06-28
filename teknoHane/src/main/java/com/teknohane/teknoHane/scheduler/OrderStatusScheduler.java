package com.teknohane.teknoHane.scheduler;

import com.teknohane.teknoHane.model.Order;
import com.teknohane.teknoHane.repository.OrderRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OrderStatusScheduler {

    private final OrderRepository orderRepository;

    public OrderStatusScheduler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Scheduled(fixedRate = 86400000) // Günde bir kez çalışır
    public void updateOrderStatuses() {
        List<Order> orders = orderRepository.findAll();
        Date now = new Date();
        for (Order order : orders) {
            if (order.getDeliveryDate().before(now) && !"DELIVERED".equals(order.getStatus())) {
                order.setStatus("DELIVERED");
                orderRepository.save(order);
            }
        }
    }
}
