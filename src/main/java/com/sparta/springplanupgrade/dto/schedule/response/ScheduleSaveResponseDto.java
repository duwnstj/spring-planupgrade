package com.sparta.springplanupgrade.dto.schedule.response;

import com.sparta.springplanupgrade.entity.Schedule;
import com.sparta.springplanupgrade.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class ScheduleSaveResponseDto {
    private final Long id;
    private final User user;
    private final String title;
    private final String content;
    private final LocalDateTime createAt;
    private final LocalDateTime updateAt;


}
