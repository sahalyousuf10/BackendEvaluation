package com.sahal.shoppingcartservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDto {

    private int itemCount;
    private double grandTotal;
    private double totalDiscount;
    private List<ItemDto> itemList;
    private ErrorDto error;
}
