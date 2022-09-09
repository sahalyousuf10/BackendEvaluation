package com.sahal.itemsservice.service;

import com.sahal.itemsservice.dto.ShoppingCartDto;
import com.sahal.itemsservice.exception.GlobalException;
import com.sahal.itemsservice.mapper.CartMapper;
import com.sahal.itemsservice.model.Item;
import com.sahal.itemsservice.model.ShoppingCart;
import com.sahal.itemsservice.repository.CartRepository;
import com.sahal.itemsservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartMapper cartMapper;

    public ShoppingCartDto createEmptyCart(ShoppingCartDto shoppingCartDto) throws GlobalException {
        try {
            ShoppingCart shoppingCart = cartMapper.dtoToEntity(shoppingCartDto);
            ShoppingCart createdCart = cartRepository.save(shoppingCart);
            ShoppingCartDto createdCartDto = cartMapper.entityToDto(createdCart);
            return createdCartDto;
        } catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw new GlobalException("Cart not created due to some internal error!");
        }

    }

    public ShoppingCartDto addItemsToCart(long cartId, long itemId) throws GlobalException {
        try {
            int count = 0;
            double grandTotal = 0;
            double totalDiscount = 0;
            List<Item> itemList = new ArrayList<>();
            ShoppingCart shoppingCart = cartRepository.findById(cartId).get();
            Item item = itemRepository.findById(itemId).get();
            shoppingCart.getItemList().add(item);
            itemList = shoppingCart.getItemList();
            for (Item items : itemList){
                count = itemList.size();
                double price = items.getPrice();
                grandTotal = price + price;
                double itemDiscount = items.getDiscount();
                double total = itemDiscount+itemDiscount;
                double average = (total / 5.0);
                totalDiscount = average;
            }
            shoppingCart.setItemCount(count);
            shoppingCart.setGrandTotal(grandTotal);
            shoppingCart.setTotalDiscount(totalDiscount);
            ShoppingCart updatedCart = cartRepository.save(shoppingCart);
            ShoppingCartDto updatedCartDto = cartMapper.entityToDto(updatedCart);
            return updatedCartDto;
        } catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw new GlobalException("Items not added due to some internal error!");
        }
    }

    public ShoppingCartDto deleteItemsFromCart(long cartId, long itemId) throws GlobalException {
        try {
            int count = 0;
            double grandTotal = 0;
            double totalDiscount = 0;
            List<Item> itemList = new ArrayList<>();
            ShoppingCart shoppingCart = cartRepository.findById(cartId).get();
            Item item = itemRepository.findById(itemId).get();
            shoppingCart.getItemList().remove(item);
            itemList = shoppingCart.getItemList();
            for (Item items : itemList){
                count = itemList.size();
                double price = items.getPrice();
                grandTotal = price + price;
                double itemDiscount = items.getDiscount();
                double total = itemDiscount+itemDiscount;
                double average = (total / 5.0);
                totalDiscount = average;
            }
            shoppingCart.setItemCount(count);
            shoppingCart.setGrandTotal(grandTotal);
            shoppingCart.setTotalDiscount(totalDiscount);
            ShoppingCart updatedCart = cartRepository.save(shoppingCart);
            ShoppingCartDto updatedCartDto = cartMapper.entityToDto(updatedCart);
            return updatedCartDto;
        } catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw new GlobalException("Items not added due to some internal error!");
        }
    }

    public void deleteCart(long cartId) throws GlobalException {
        try {
            cartRepository.deleteById(cartId);
        } catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw new GlobalException("Cart not deleted due to some internal error!");
        }
    }
}
