package com.luiz.cifravernamapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> tratarErroDeValidacao(
            MethodArgumentNotValidException exception) {

        String mensagem = exception.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(mensagem);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> tratarErroDeEntrada(
        IllegalArgumentException exception) {

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(exception.getMessage());
}
}