package com.example.springboot.api_demo.service;

import java.util.List;

import com.example.springboot.api_demo.dto.UserRequestDto;
import com.example.springboot.api_demo.dto.UserResponseDto;

public interface UserServiceInterface {
    List<UserResponseDto> findUserList();
    UserResponseDto findUserById(Long id);
    UserResponseDto addUser(UserRequestDto dto);
}