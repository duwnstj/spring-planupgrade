package com.sparta.springplanupgrade.dto.schedule.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleSaveRequestDto {
    private Long userId;
    private String content;
    private String title;
}
