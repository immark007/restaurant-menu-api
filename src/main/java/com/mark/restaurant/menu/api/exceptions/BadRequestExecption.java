package com.mark.restaurant.menu.api.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestExecption extends RuntimeException {
    public BadRequestExecption(String message) {
        super(message);
    }
}
