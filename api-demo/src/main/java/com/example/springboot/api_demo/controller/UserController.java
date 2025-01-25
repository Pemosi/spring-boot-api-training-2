package com.example.springboot.api_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.api_demo.dto.user.UserRequestDto;
import com.example.springboot.api_demo.dto.user.UserResponseDto;
import com.example.springboot.api_demo.usecase.UserUsecase;

@Validated
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserUsecase usecase;

	@GetMapping
	public ResponseEntity<List<UserResponseDto>> getAllUsers() {
		final List<UserResponseDto> users = this.usecase.findUserList();
		return ResponseEntity.ok(users);
	}

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Long id) {
		final UserResponseDto user = this.usecase.findUserById(id);
		return ResponseEntity.ok(user);
    }

	@PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Validated UserRequestDto dto) {
		final UserResponseDto user = this.usecase.addUser(dto);
		return ResponseEntity.ok(user);
    }

	@PatchMapping("/{id}/switchActive")
    public ResponseEntity<Boolean> updateUserActive(@PathVariable("id") Long id) {
        final boolean isActive = this.usecase.switchUserActiveById(id);
        return ResponseEntity.ok(isActive);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
	// 	// TODO: 指定したIDのユーザーを更新する
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {
        final boolean deleteUser = this.usecase.deleteUserById(id);
    	return ResponseEntity.ok(deleteUser);
    }
}