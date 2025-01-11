package com.example.springboot.api_demo.dto.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ValidationErrorDto {
    private String field;
    private String message;
}