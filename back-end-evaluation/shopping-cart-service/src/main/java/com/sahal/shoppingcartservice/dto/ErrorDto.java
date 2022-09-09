package com.sahal.shoppingcartservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

    private String detail;
    private String message;
    private Date timeStamp;
}
