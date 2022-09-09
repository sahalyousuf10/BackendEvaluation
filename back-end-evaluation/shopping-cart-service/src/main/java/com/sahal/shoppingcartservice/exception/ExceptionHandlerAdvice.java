package com.sahal.shoppingcartservice.exception;

import com.sahal.shoppingcartservice.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    //Handle specific exception
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleResourceNotFoundException(
            ResourceNotFoundException exception){
        ErrorDto errorDto = new ErrorDto(
                "Resource not found",
                exception.getMessage(),
                new Date());
        return errorDto;
    }

    //handle global exceptions
    @ExceptionHandler(GlobalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleGlobalException
    (GlobalException exception){
        ErrorDto errorDto = new ErrorDto(
                "Error",
                exception.getMessage(),
                new Date());
        return errorDto;
    }
}
