package com.sparta.springplanupgrade.dto.user.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserDetailResponseDto {
    private final Long id;
    private final String userName;
    private final String email;
}
