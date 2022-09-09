package com.sahal.shoppingcartservice.feign;

import com.sahal.shoppingcartservice.dto.ShoppingCartDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "item-service",
        url = "http://localhost:8080/item",
        fallback = ItemFeignFallback.class)
public interface ItemFeignService {

    @PostMapping
    ResponseEntity<ShoppingCartDto> createEmptyCart(@RequestBody ShoppingCartDto shoppingCartDto);

    @PutMapping(value = "/{cartID}/{itemId}")
    ResponseEntity<ShoppingCartDto> addItemsToCart(@PathVariable long cartId, @PathVariable long itemId);

    @DeleteMapping(value = "/{cartID}/{itemId")
    ResponseEntity<ShoppingCartDto> deleteItemFromCart(@PathVariable long cartId, @PathVariable long itemId);

    @DeleteMapping("/{cartID")
    ResponseEntity deleteCart(@PathVariable long cartId);
}
