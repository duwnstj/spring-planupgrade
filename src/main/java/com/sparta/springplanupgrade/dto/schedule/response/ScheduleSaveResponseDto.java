package com.sparta.springplanupgrade.dto.schedule.response;

import com.sparta.springplanupgrade.entity.Schedule;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class ScheduleSaveResponseDto {
    private final Long id;
    private final String userName;
    private final String title;
    private final String content;
    private final LocalDateTime createAt;
    private final LocalDateTime updateAt;


    public ScheduleSaveResponseDto(Schedule savedSchedule) {
        this.id = savedSchedule.getId();
        this.userName = savedSchedule.getUserName();
        this.title = savedSchedule.getTitle();
        this.content = savedSchedule.getContent();
        this.createAt = savedSchedule.getCreateAt();
        this.updateAt = savedSchedule.getUpdateAt();
    }


}
