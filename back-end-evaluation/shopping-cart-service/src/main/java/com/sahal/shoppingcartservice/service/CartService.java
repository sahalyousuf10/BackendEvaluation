package com.sahal.shoppingcartservice.service;

import com.sahal.shoppingcartservice.dto.ShoppingCartDto;
import com.sahal.shoppingcartservice.exception.GlobalException;
import com.sahal.shoppingcartservice.feign.ItemFeignService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartService {

    @Autowired
    private ItemFeignService itemFeignService;

    public ShoppingCartDto createEmptyCart(ShoppingCartDto shoppingCartDto) throws GlobalException {
        try{

            ShoppingCartDto createdShoppingCart = itemFeignService.createEmptyCart(shoppingCartDto).getBody();
            return createdShoppingCart;
        } catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw new GlobalException("Cart not created due to some internal error!");
        }
    }

    public ShoppingCartDto addItemsToCart(long cartId, long itemId, ShoppingCartDto shoppingCartDto) throws GlobalException {
        try {
            ShoppingCartDto updatedShoppingCart = itemFeignService.addItemsToCart(cartId, itemId).getBody();
            return updatedShoppingCart;
        } catch (Exception ex) {
            log.error("Exception caught "+ex.getMessage());
            throw new GlobalException("Items not added into cart due to some internal error!");
        }
    }

    public ShoppingCartDto deleteItemFromCart(long cartId, long itemId) throws GlobalException {
        try {
            ShoppingCartDto updatedShoppingCart = itemFeignService.deleteItemFromCart(cartId, itemId).getBody();
            return updatedShoppingCart;
        } catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw new GlobalException("Item not deleted due to some internal error!");
        }
    }

    public void deleteCart(long cartId) throws GlobalException {
        try {
            itemFeignService.deleteCart(cartId);
        } catch (Exception ex) {
            log.error("Exception caught: "+ ex.getMessage());
            throw new GlobalException("Cart not deleted due to some internal error!");
        }
    }
}
