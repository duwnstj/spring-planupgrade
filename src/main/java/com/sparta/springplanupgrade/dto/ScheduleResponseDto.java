package com.sparta.springplanupgrade.dto;

import com.sparta.springplanupgrade.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String userName;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;



    public ScheduleResponseDto(Schedule savedSchedule) {
        this.id = savedSchedule.getId();
        this.userName = savedSchedule.getUserName();
        this.title = savedSchedule.getTitle();
        this.content = savedSchedule.getContent();
        this.createAt = savedSchedule.getCreateAt();
        this.updateAt = savedSchedule.getUpdateAt();
    }


}
