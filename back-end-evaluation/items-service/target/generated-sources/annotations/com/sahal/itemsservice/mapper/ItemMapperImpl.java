package com.sahal.itemsservice.mapper;

import com.sahal.itemsservice.dto.ItemDto;
import com.sahal.itemsservice.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-11T14:57:47+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemDto entityToDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setQuantity( item.getQuantity() );
        itemDto.setUpc( item.getUpc() );
        itemDto.setColor( item.getColor() );
        itemDto.setPrice( item.getPrice() );
        itemDto.setDiscount( item.getDiscount() );

        return itemDto;
    }

    @Override
    public Item dtoToEntity(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setQuantity( itemDto.getQuantity() );
        item.setUpc( itemDto.getUpc() );
        item.setColor( itemDto.getColor() );
        item.setPrice( itemDto.getPrice() );
        item.setDiscount( itemDto.getDiscount() );

        return item;
    }

    @Override
    public List<ItemDto> entityToDto(List<Item> itemList) {
        if ( itemList == null ) {
            return null;
        }

        List<ItemDto> list = new ArrayList<ItemDto>( itemList.size() );
        for ( Item item : itemList ) {
            list.add( entityToDto( item ) );
        }

        return list;
    }

    @Override
    public List<Item> dtoToEntity(List<ItemDto> itemDtoList) {
        if ( itemDtoList == null ) {
            return null;
        }

        List<Item> list = new ArrayList<Item>( itemDtoList.size() );
        for ( ItemDto itemDto : itemDtoList ) {
            list.add( dtoToEntity( itemDto ) );
        }

        return list;
    }
}
