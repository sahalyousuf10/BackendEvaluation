package com.sahal.itemsservice.controller;

import com.sahal.itemsservice.dto.ShoppingCartDto;
import com.sahal.itemsservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<ShoppingCartDto> createEmptyCart(
            @RequestBody ShoppingCartDto shoppingCartDto) throws Exception {
        ShoppingCartDto createdCart = cartService.createEmptyCart(shoppingCartDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdCart);
    }

    @PutMapping(value = "/{cartId}/{itemId}")
    private ResponseEntity<ShoppingCartDto> addItemsToCart(
            @PathVariable long cartId, long itemId) throws Exception {
        ShoppingCartDto updatedCart = cartService.addItemsToCart(cartId, itemId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(updatedCart);
    }

    @DeleteMapping(value = "/{cartId}/{itemId}")
    public ResponseEntity<ShoppingCartDto> deleteItemFromCart(
            @PathVariable long cartId, @PathVariable long itemId) throws Exception {
        ShoppingCartDto updatedCart = cartService.deleteItemsFromCart(cartId, itemId);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping(value = "/{cartId}")
    public ResponseEntity deleteCart(
            @PathVariable long cartId) throws Exception {
        cartService.deleteCart(cartId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
