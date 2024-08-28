package com.sparta.springplanupgrade.controller;

import com.sparta.springplanupgrade.dto.CommentRequestDto;
import com.sparta.springplanupgrade.dto.CommentResponseDto;
import com.sparta.springplanupgrade.entity.Comment;
import com.sparta.springplanupgrade.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    // 일정 아이디를 찾아 댓글 저장
    @PostMapping("/{scheduleId}")
    public ResponseEntity<CommentResponseDto> createComment(@PathVariable(name = "scheduleId") Long scheduleId, @RequestBody CommentRequestDto commentRequestDto) {
        CommentResponseDto saveComment = commentService.createComment(scheduleId, commentRequestDto);

        return ResponseEntity.ok(saveComment);
    }


}
