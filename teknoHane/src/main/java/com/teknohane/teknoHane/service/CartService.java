package com.teknohane.teknoHane.service;

import com.teknohane.teknoHane.model.dto.CartDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface CartService {

    List<CartDTO> getAllCart();
    CartDTO getCartById(Long cartId);

    List<CartDTO> GetCartByUserId (Long userId);
    CartDTO create (Authentication authentication, CartDTO cartDTO);
    CartDTO updateCart (CartDTO cartDTO , Long cartId);

    boolean deleteCart (Long cartId);

    int deleteByProductId (Long productId);


}
