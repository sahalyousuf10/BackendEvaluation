package com.sahal.itemsservice.exception;

import com.sahal.itemsservice.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected Map<String, String> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(x -> {
                    errors.put(x.getField(),
                            x.getDefaultMessage());}
                );
        return errors;
    }

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
