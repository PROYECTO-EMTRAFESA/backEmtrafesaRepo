package com.emtrafesa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Manejar excepciones de tipo IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        // Retornar solo el mensaje de la excepción
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Manejar excepciones genéricas (cualquier otro tipo de excepción no manejada)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        // Retornar un mensaje general si ocurre algún otro error no controlado
        return new ResponseEntity<>("Ocurrió un error inesperado. Por favor, inténtelo de nuevo.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
