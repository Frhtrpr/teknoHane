package com.teknohane.teknoHane.service.impl;

import com.teknohane.teknoHane.model.OrderDetail;
import com.teknohane.teknoHane.model.dto.OrderDetailDTO;
import com.teknohane.teknoHane.model.mapper.OrderDetailMapper;
import com.teknohane.teknoHane.repository.OrderDetailRepository;
import com.teknohane.teknoHane.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetailDTO> getAllOrderDetail() {
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
        return orderDetails.stream()
                .map(OrderDetailMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDetailDTO getOrderDetailById(Long id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order detail not found with id: " + id));
        return OrderDetailMapper.toDTO(orderDetail);
    }

    @Override
    public OrderDetailDTO createOrderDetail(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = OrderDetailMapper.toEntity(orderDetailDTO);
        orderDetail = orderDetailRepository.save(orderDetail);
        return OrderDetailMapper.toDTO(orderDetail);
    }

    @Override
    public OrderDetailDTO updateOrderDetail(OrderDetailDTO orderDetailDTO, Long id) {
        OrderDetail existingOrderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order detail not found with id: " + id));
        OrderDetail updatedOrderDetail = OrderDetailMapper.toEntity(orderDetailDTO);
        updatedOrderDetail.setOrderDetailId(existingOrderDetail.getOrderDetailId());
        updatedOrderDetail = orderDetailRepository.save(updatedOrderDetail);
        return OrderDetailMapper.toDTO(updatedOrderDetail);
    }

    @Override
    public boolean deleteOrderDetail(Long id) {
        if (orderDetailRepository.existsById(id)) {
            orderDetailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
