package com.sahal.shoppingcartservice.feign;

import com.sahal.shoppingcartservice.dto.ErrorDto;
import com.sahal.shoppingcartservice.dto.ShoppingCartDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Component
@Slf4j
public class ItemFeignFallback implements ItemFeignService {

    public ResponseEntity<ShoppingCartDto> createEmptyCart(@RequestBody ShoppingCartDto shoppingCartDto){
        ErrorDto error = new ErrorDto();
        error.setDetail("Error");
        error.setMessage("Service down!");
        error.setTimeStamp(new Date());
        ShoppingCartDto shoppingCartDto1 = new ShoppingCartDto();
        shoppingCartDto.setError(error);
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(shoppingCartDto1);
    }

    public ResponseEntity<ShoppingCartDto> addItemsToCart(@PathVariable long cartId, @PathVariable long itemId){
        ErrorDto error = new ErrorDto();
        error.setDetail("Error");
        error.setMessage("Service down!");
        error.setTimeStamp(new Date());
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        shoppingCartDto.setError(error);
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(shoppingCartDto);
    }

    public ResponseEntity<ShoppingCartDto> deleteItemFromCart(@PathVariable long cartId, @PathVariable long itemId){
        ErrorDto error = new ErrorDto();
        error.setDetail("Error");
        error.setMessage("Service down!");
        error.setTimeStamp(new Date());
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        shoppingCartDto.setError(error);
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(shoppingCartDto);
    }

    public ResponseEntity deleteCart(@PathVariable long cartId){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}
