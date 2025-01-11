package com.example.springboot.api_demo.dto.error;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponseDto {
    private int statusCode;
    private String message;
    private List<ValidationErrorDto> validationErrors;
}