package com.sahal.itemsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.sahal.itemsservice.constant.Constant.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    @NotNull(message = QUANTITY_NOT_NULL_ERROR_MESSAGE)
    @Positive(message = QUANTITY_SHOULD_BE_POSITIVE_ERROR_MESSAGE)
    private int quantity;

    @NotNull(message = UPC_NOT_NULL_ERROR_MESSAGE)
    @Positive(message = UPC_SHOULD_BE_POSITIVE_ERROR_MESSAGE)
    private long upc;

    @NotBlank(message = COLOR_MANDATORY_ERROR_MESSAGE)
    private String color;

    @NotNull(message = PRICE_NOT_NULL_ERROR_MESSAGE)
    @Positive(message = PRICE_SHOULD_BE_POSITIVE_ERROR_MESSAGE)
    private double price;

    @NotNull(message = DISCOUNT_NOT_NULL_ERROR_MESSAGE)
    @Positive(message = DISCOUNT_SHOULD_BE_POSITIVE_ERROR_MESSAGE)
    private double discount;
}
