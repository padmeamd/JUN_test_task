package com.shoppinglist.shopping.list.app.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public CustomExceptionWrapper handleNotFoundExceptions(EntityNotFoundException ex){
        log.error("Cannot find entity by id!");
        return new CustomExceptionWrapper(ex.getMessage(), LocalDateTime.now());
    }
}
