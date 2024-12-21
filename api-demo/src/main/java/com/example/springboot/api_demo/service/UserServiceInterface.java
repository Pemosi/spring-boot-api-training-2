package com.example.springboot.api_demo.service;

import java.util.List;

import com.example.springboot.api_demo.dto.UserResponseDto;

public interface UserServiceInterface {
    List<UserResponseDto> findUserList();
    // TODO: 以下のインターフェースのコメントアウトを外して、UserServiceの処理を実装する
    UserResponseDto findUserById(Long id);
    // UserResponseDto addUser(UserRequestDto dto);
}
