package com.sparta.springplanupgrade.dto.manager.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

public class ManagerSaveResponseDto {

    private final Long id;

    public ManagerSaveResponseDto(Long id) {
        this.id = id;
    }
}
