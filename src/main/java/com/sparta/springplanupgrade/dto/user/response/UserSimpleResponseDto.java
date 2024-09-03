package com.sparta.springplanupgrade.dto.user.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserSimpleResponseDto {
    private final Long id;
    private final String userName;
}
