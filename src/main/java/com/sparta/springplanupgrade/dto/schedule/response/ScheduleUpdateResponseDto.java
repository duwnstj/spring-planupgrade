package com.sparta.springplanupgrade.dto.schedule.response;

import lombok.Getter;

@Getter
public class ScheduleUpdateResponseDto {

    private Long id;

    public ScheduleUpdateResponseDto(Long id) {
        this.id = id;
    }
}
