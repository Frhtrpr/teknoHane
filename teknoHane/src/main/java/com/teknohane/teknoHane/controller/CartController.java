package com.teknohane.teknoHane.controller;

import com.teknohane.teknoHane.model.Users;
import com.teknohane.teknoHane.model.dto.CartDTO;
import com.teknohane.teknoHane.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @GetMapping("/get")
    public ResponseEntity<List<CartDTO>> getAllCarts (){
        List<CartDTO> cartList = cartService.getAllCart();
        return new ResponseEntity<>(cartList , HttpStatus.OK);
    }

    @GetMapping("/get/{cartId}")
    public ResponseEntity<CartDTO> getCartById (@PathVariable  Long cartId) {
        CartDTO cart = cartService.getCartById(cartId);
        return  new ResponseEntity<>(cart , HttpStatus.OK);
    }

    @GetMapping("/getCartByUserId")
    public ResponseEntity<List<CartDTO>>getCartByUserId(Authentication authentication){
        Long cartToken =  ((Users)authentication.getPrincipal()).getId();
        List<CartDTO> cartByUserId = cartService.GetCartByUserId(cartToken);
        return new ResponseEntity<>(cartByUserId , HttpStatus.OK);
    }

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> createCart (Authentication authentication ,@RequestBody CartDTO cartDTO){
        Date now = new Date();
        cartDTO.setCreatedAt(now);
        cartDTO.setQuantity(cartDTO.getQuantity() + 1);
        CartDTO cart = cartService.create(authentication,cartDTO);
        return new ResponseEntity<>(cart , HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<CartDTO> updatecart (@RequestBody CartDTO cartDTO , @PathVariable Long cartId ){
        CartDTO cart = cartService.updateCart(cartDTO,cartId);
        return  new ResponseEntity<>(cart , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<String> deleteCart(@PathVariable Long cartId) {
        boolean deleted = cartService.deleteCart(cartId);
        if (deleted) {
            return new ResponseEntity<>("Deleted " + cartId, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteByProductId/{productId}")
    public ResponseEntity<String> deleteCartByProductId (@PathVariable Long productId){
        int affectedRows = cartService.deleteByProductId(productId);
        if (affectedRows > 0) {
            return new ResponseEntity<>("Carts deleted by productId: " + productId, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("No carts found for productId: " + productId, HttpStatus.NOT_FOUND);
        }
    }

}
