package com.sparta.springplanupgrade.dto.schedule.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleDetailResponseDto {

    private final Long id;
    private final String title;
    private final String userName;
    private final String content;

}
