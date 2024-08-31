package com.sparta.springplanupgrade.dto.schedule.response;

import com.sparta.springplanupgrade.dto.user.UserDto;
import com.sparta.springplanupgrade.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter

public class ScheduleDetailResponseDto {

    private final Long id;
    private final String title;
    private final UserDto user;
    private final String content;
    private final LocalDateTime createAt;
    private final LocalDateTime updateAt;
    private final int commentCount;

    public ScheduleDetailResponseDto(Long id, String title, UserDto user, String content, LocalDateTime createAt, LocalDateTime updateAt, int commentCount) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.commentCount = commentCount;
    }
}
