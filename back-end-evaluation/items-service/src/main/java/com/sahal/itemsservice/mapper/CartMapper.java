package com.sahal.itemsservice.mapper;

import com.sahal.itemsservice.dto.ItemDto;
import com.sahal.itemsservice.dto.ShoppingCartDto;
import com.sahal.itemsservice.model.Item;
import com.sahal.itemsservice.model.ShoppingCart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    ShoppingCartDto entityToDto(ShoppingCart shoppingCart);
    ShoppingCart dtoToEntity(ShoppingCartDto shoppingCartDto);
    List<ShoppingCartDto> entityToDto(List<ShoppingCart> cartList);
    List<ShoppingCart> dtoToEntity(List<ShoppingCartDto> cartDtoList);
}
