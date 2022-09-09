package com.sahal.itemsservice.mapper;

import com.sahal.itemsservice.dto.ShoppingCartDto;
import com.sahal.itemsservice.model.ShoppingCart;
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
public class CartMapperImpl implements CartMapper {

    @Override
    public ShoppingCartDto entityToDto(ShoppingCart shoppingCart) {
        if ( shoppingCart == null ) {
            return null;
        }

        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();

        shoppingCartDto.setItemCount( shoppingCart.getItemCount() );
        shoppingCartDto.setGrandTotal( shoppingCart.getGrandTotal() );
        shoppingCartDto.setTotalDiscount( shoppingCart.getTotalDiscount() );

        return shoppingCartDto;
    }

    @Override
    public ShoppingCart dtoToEntity(ShoppingCartDto shoppingCartDto) {
        if ( shoppingCartDto == null ) {
            return null;
        }

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setItemCount( shoppingCartDto.getItemCount() );
        shoppingCart.setGrandTotal( shoppingCartDto.getGrandTotal() );
        shoppingCart.setTotalDiscount( shoppingCartDto.getTotalDiscount() );

        return shoppingCart;
    }

    @Override
    public List<ShoppingCartDto> entityToDto(List<ShoppingCart> cartList) {
        if ( cartList == null ) {
            return null;
        }

        List<ShoppingCartDto> list = new ArrayList<ShoppingCartDto>( cartList.size() );
        for ( ShoppingCart shoppingCart : cartList ) {
            list.add( entityToDto( shoppingCart ) );
        }

        return list;
    }

    @Override
    public List<ShoppingCart> dtoToEntity(List<ShoppingCartDto> cartDtoList) {
        if ( cartDtoList == null ) {
            return null;
        }

        List<ShoppingCart> list = new ArrayList<ShoppingCart>( cartDtoList.size() );
        for ( ShoppingCartDto shoppingCartDto : cartDtoList ) {
            list.add( dtoToEntity( shoppingCartDto ) );
        }

        return list;
    }
}
