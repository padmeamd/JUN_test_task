package com.shoppinglist.shopping.list.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomExceptionWrapper {
    private String message;
    private LocalDateTime dateTime;
}
