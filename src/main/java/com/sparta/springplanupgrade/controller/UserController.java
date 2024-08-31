package com.sparta.springplanupgrade.controller;

import com.sparta.springplanupgrade.dto.user.request.UserSaveRequestDto;
import com.sparta.springplanupgrade.dto.user.response.UserSaveResponseDto;
import com.sparta.springplanupgrade.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserSaveResponseDto SaveUser(@RequestBody UserSaveRequestDto userSaveRequestDto) {

        return userService.saveUser(userSaveRequestDto);

        //잃어버린 User 저장까지의 요구사항들 찾아서 복구 완료
    }
}
