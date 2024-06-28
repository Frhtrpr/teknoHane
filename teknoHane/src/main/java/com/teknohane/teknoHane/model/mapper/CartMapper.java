package com.teknohane.teknoHane.model.mapper;

import com.teknohane.teknoHane.model.Cart;
import com.teknohane.teknoHane.model.Category;
import com.teknohane.teknoHane.model.dto.CartDTO;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public static CartDTO toDTO (Cart cart){
        CartDTO dto = new CartDTO();
        dto.setCartId(cart.getCartId());
        dto.setUserId(cart.getUserId());
        dto.setProductId(cart.getProductId());
        dto.setQuantity(cart.getQuantity());
        dto.setTotalPrice(cart.getTotalPrice());
        dto.setCreatedAt(cart.getCreatedAt());
        return dto;
    }

    public static Cart toEntity (CartDTO cartDTO){
        Cart cart = new Cart();
        cart.setCartId(cartDTO.getCartId());
        cart.setUserId(cartDTO.getUserId());
        cart.setProductId(cartDTO.getProductId());
        cart.setQuantity(cartDTO.getQuantity());
        cart.setTotalPrice(cartDTO.getTotalPrice());
        cart.setCreatedAt(cartDTO.getCreatedAt());

        return cart;
    }
}
