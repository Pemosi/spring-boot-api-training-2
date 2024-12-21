package com.example.springboot.api_demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.api_demo.dto.UserResponseDto;
import com.example.springboot.api_demo.entity.UserEntity;
import com.example.springboot.api_demo.repository.UserRepository;
import com.example.springboot.api_demo.utils.UserMapper;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    public UserMapper mapper;

    @Autowired
    public UserRepository repository;

    // ユーザー情報取得 - 一覧
    public List<UserResponseDto> findUserList() {
        // 拡張for文による書き方
        List<UserResponseDto> userDtoList = new ArrayList<>();
        for (UserEntity entity : repository.findAll()) {
            userDtoList.add(mapper.mapToDto(entity));
        }
        return userDtoList;

        // streamを用いた書き方
        // return repository.findAll()
        // .stream()
        // .map(entity -> mapper.mapToDto(entity))
        // .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto findUserById(Long id) {
        var entity = repository.findById(id).get();
        return mapper.mapToDto(entity);
    }
}
