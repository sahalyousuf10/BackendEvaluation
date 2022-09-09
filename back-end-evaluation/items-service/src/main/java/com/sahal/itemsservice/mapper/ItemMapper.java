package com.sahal.itemsservice.mapper;

import com.sahal.itemsservice.dto.ItemDto;
import com.sahal.itemsservice.model.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDto entityToDto(Item item);
    Item dtoToEntity(ItemDto itemDto);
    List<ItemDto> entityToDto(List<Item> itemList);
    List<Item> dtoToEntity(List<ItemDto> itemDtoList);
}
