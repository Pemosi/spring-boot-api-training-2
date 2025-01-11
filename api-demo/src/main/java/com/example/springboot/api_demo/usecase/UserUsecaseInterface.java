package com.example.springboot.api_demo.usecase;

import java.util.List;

import com.example.springboot.api_demo.dto.user.UserRequestDto;
import com.example.springboot.api_demo.dto.user.UserResponseDto;

public interface UserUsecaseInterface {
    List<UserResponseDto> findUserList();
    UserResponseDto findUserById(Long id);
    UserResponseDto addUser(UserRequestDto dto);
}
