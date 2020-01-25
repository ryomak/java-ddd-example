package com.ykfoot.footapi.presentation.controller.resouce.handler;

import com.ykfoot.footapi.infrastructure.repository.exception.NoneException;
import com.ykfoot.footapi.presentation.controller.resouce.response.ErrorReponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoneException.class)
    public ResponseEntity handlerException(NoneException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(
                ErrorReponse.builder()
                .errorCode("10000")
                .errorMessage(ex.getMessage())
                .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerException(Exception ex) {
        log.error("unexpected error:{}",ex.getMessage(),ex);
        return new ResponseEntity<>(
                ErrorReponse.builder()
                        .errorCode("20000")
                        .errorMessage(ex.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
