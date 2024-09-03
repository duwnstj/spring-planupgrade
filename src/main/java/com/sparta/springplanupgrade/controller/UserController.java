package com.sparta.springplanupgrade.controller;

import com.sparta.springplanupgrade.dto.user.request.UserSaveRequestDto;
import com.sparta.springplanupgrade.dto.user.response.UserDetailResponseDto;
import com.sparta.springplanupgrade.dto.user.response.UserSaveResponseDto;
import com.sparta.springplanupgrade.dto.user.response.UserSimpleResponseDto;
import com.sparta.springplanupgrade.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 저장
    @PostMapping("/users")
    public ResponseEntity<UserSaveResponseDto> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto) {

        return ResponseEntity.ok(userService.saveUser(userSaveRequestDto));
    }

    // 유저 전체 조회
    @GetMapping("/users")
    public ResponseEntity<List<UserSimpleResponseDto>> getUsers() {

        return ResponseEntity.ok(userService.getUsers());
    }

    // 유저 단건 조회
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDetailResponseDto> getUser(@PathVariable Long userId) {

        return ResponseEntity.ok(userService.getUser(userId));
    }

    // 유저 삭제
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
