package com.sahal.shoppingcartservice.controller;

import com.sahal.shoppingcartservice.dto.ShoppingCartDto;
import com.sahal.shoppingcartservice.service.CartService;
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
        ShoppingCartDto createdShoppingCart = cartService.createEmptyCart(shoppingCartDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(shoppingCartDto);
    }

    @PutMapping(value = "/{id}/item/{itemId}")
    public ResponseEntity<ShoppingCartDto> addItemsToCart(
            @PathVariable long id, @PathVariable long itemId, @RequestBody ShoppingCartDto shoppingCartDto) throws Exception {
        ShoppingCartDto updatedShoppingCart = cartService.addItemsToCart(id, itemId, shoppingCartDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(updatedShoppingCart);
    }

    @DeleteMapping(value = "/{cartId}/{itemId}")
    public ResponseEntity<ShoppingCartDto> deleteItemsFromCart(
            @PathVariable long cartId, @PathVariable long itemId) throws Exception {
        ShoppingCartDto updatedShoppingCart = cartService.deleteItemFromCart(cartId, itemId);
        return ResponseEntity.ok(updatedShoppingCart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity deleteCart(
            @PathVariable long cartId) throws Exception {
        cartService.deleteCart(cartId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
