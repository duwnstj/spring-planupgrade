package com.sparta.springplanupgrade.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleSaveRequestDto {
    private String userName;
    private String content;
    private String title;
}
