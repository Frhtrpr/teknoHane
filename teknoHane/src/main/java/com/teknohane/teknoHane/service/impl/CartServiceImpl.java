package com.teknohane.teknoHane.service.impl;

import com.teknohane.teknoHane.model.Cart;
import com.teknohane.teknoHane.model.Category;
import com.teknohane.teknoHane.model.Favorites;
import com.teknohane.teknoHane.model.Users;
import com.teknohane.teknoHane.model.dto.CartDTO;
import com.teknohane.teknoHane.model.dto.FavoritesDTO;
import com.teknohane.teknoHane.model.mapper.CartMapper;
import com.teknohane.teknoHane.model.mapper.CategoryMapper;
import com.teknohane.teknoHane.model.mapper.FavoritesMapper;
import com.teknohane.teknoHane.repository.CartRepository;
import com.teknohane.teknoHane.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {


    private final CartRepository cartRepository;

    @Override
    public List<CartDTO> getAllCart() {
        List<Cart> carts = cartRepository.findAll();
        return carts.stream().map(CartMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CartDTO getCartById(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found with cartId"+ cartId));
        return CartMapper.toDTO(cart);
    }

    @Override
    public List<CartDTO> GetCartByUserId(Long userId) {
        List<Cart> carts = cartRepository.getCartByUserId(userId);
        return carts.stream().map(CartMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CartDTO create(Authentication authentication,CartDTO cartDTO) {
        Users users = (Users) authentication.getPrincipal();
        Cart cart = CartMapper.toEntity(cartDTO);
        cart.setUserId(users.getId());
        cart = cartRepository.save(cart);
        return CartMapper.toDTO(cart);
    }


    @Override
    public CartDTO updateCart(CartDTO cartDTO, Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + cartId));

        cartDTO.setUserId(cart.getUserId());
        cartDTO.setProductId(cart.getProductId());

        cart.setQuantity(cartDTO.getQuantity());

        cart = cartRepository.save(cart);

        return CartMapper.toDTO(cart);
    }


    @Override
    public boolean deleteCart(Long cartId) {
        if (!cartRepository.existsById(cartId)) {
            return false;
        }
        cartRepository.deleteById(cartId);
        return true;
    }

    @Override
    @Transactional
    public int deleteByProductId(Long productId) {
        return cartRepository.deleteByProductId(productId);
    }


}
