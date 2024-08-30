package com.sparta.springplanupgrade.dto.schedule.response;

import lombok.Getter;

@Getter
public class ScheduleSimpleResponstDto {

    private final String title;

    public ScheduleSimpleResponstDto(String title) {
        this.title = title;
    }
}
