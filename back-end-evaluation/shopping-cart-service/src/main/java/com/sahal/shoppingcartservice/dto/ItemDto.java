package com.sahal.shoppingcartservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private int quantity;
    private long upc;
    private String color;
    private double price;
    private double discount;
    private ErrorDto error;
}
