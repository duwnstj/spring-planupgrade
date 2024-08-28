package com.sparta.springplanupgrade.dto;

import com.sparta.springplanupgrade.entity.Comment;
import com.sparta.springplanupgrade.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class CommentResponseDto {
    private Long id;
    private String userName;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private Long scheduleId;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.userName = comment.getUserName();
        this.content = comment.getContent();
        this.createAt = comment.getCreateAt();
        this.updateAt = comment.getUpdateAt();
        this.scheduleId = comment.getSchedule().getId();
    }
}
