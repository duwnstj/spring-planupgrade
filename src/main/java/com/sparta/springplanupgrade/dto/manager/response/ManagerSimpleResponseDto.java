package com.sparta.springplanupgrade.dto.manager.response;

import com.sparta.springplanupgrade.dto.user.UserDto;
import lombok.Getter;

@Getter
public class ManagerSimpleResponseDto {
    private final Long id;
    private final UserDto user;

    public ManagerSimpleResponseDto(Long id, UserDto user) {
        this.id = id;
        this.user = user;
    }
}
