package com.sparta.springplanupgrade.dto.comment.response;

import com.sparta.springplanupgrade.dto.user.UserDto;
import com.sparta.springplanupgrade.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class CommentResponseDto {
    private final Long id;
    private final UserDto user;
    private final String content;
    private final LocalDateTime createAt;
    private final LocalDateTime updateAt;


}
