package com.mark.restaurant.menu.api.handler;

import com.mark.restaurant.menu.api.exceptions.BadRequestExceptionsDetails;
import com.mark.restaurant.menu.api.exceptions.BadRequestExecption;
import com.mark.restaurant.menu.api.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestExecption.class)
    public ResponseEntity<BadRequestExceptionsDetails> handlerBadRequestExceptionsDetails(BadRequestExecption bre) {
        return new ResponseEntity<>(
                BadRequestExceptionsDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Check the Documentation")
                        .details(bre.getMessage()).details(bre.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BadRequestExceptionsDetails> handlerNotFoundException(NotFoundException bre) {
        return new ResponseEntity<>(
                BadRequestExceptionsDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("Not found Exception")
                        .details(bre.getMessage()).details(bre.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND);
    }
}
