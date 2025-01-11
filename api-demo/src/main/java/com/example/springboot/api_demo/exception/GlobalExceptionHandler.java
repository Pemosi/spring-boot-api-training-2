package com.example.springboot.api_demo.exception;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springboot.api_demo.dto.error.ErrorResponseDto;
import com.example.springboot.api_demo.dto.error.ValidationErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDto> handleNoSuchElementException(NoSuchElementException ex) {
        final var validationErrors = List.of(
            ValidationErrorDto
            .builder()
            .field("id")
            .message(ex.getMessage())
            .build()
        );
        final var response = ErrorResponseDto
        .builder()
        .statusCode(HttpStatus.NOT_FOUND.value())
        .message("データが見つかりません")
        .validationErrors(validationErrors)
        .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        final var validationErrors = ex.getBindingResult().getFieldErrors()
        .stream()
        .map(error -> new ValidationErrorDto(error.getField(), error.getDefaultMessage()))
        .collect(Collectors.toList());

        final var response = ErrorResponseDto
        .builder()
        .statusCode(HttpStatus.BAD_REQUEST.value())
        .message("バリデーションエラー")
        .validationErrors(validationErrors)
        .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(Exception ex) {
        final var response = ErrorResponseDto
        .builder()
        .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .message(ex.getMessage())
        .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}