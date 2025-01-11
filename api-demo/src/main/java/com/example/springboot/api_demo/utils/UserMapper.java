package com.example.springboot.api_demo.utils;

import org.springframework.stereotype.Component;

import com.example.springboot.api_demo.dto.user.UserResponseDto;
import com.example.springboot.api_demo.entity.UserEntity;

@Component
public class UserMapper {
    public UserResponseDto mapToDto(UserEntity entity) {
        // lombokのbuilderパターンで書く場合
        return UserResponseDto
        .builder()
        .id(entity.getId())
        .name(entity.getName())
        .email(entity.getEmail())
        .isActive(entity.isActive())
        .build();

        // new UserResponseDtoで書く場合
        // return new UserResponseDto(entity.getId(), entity.getName(), entity.getEmail(), entity.isActive());
    }
}
