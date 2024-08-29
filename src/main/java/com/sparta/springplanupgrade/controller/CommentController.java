package com.sparta.springplanupgrade.controller;

import com.sparta.springplanupgrade.dto.request.CommentRequestDto;
import com.sparta.springplanupgrade.dto.response.CommentResponseDto;
import com.sparta.springplanupgrade.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 댓글 아이디를 기준으로 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> inquireComment(@PathVariable(name = "id") Long id) {
        CommentResponseDto inquire = commentService.inquireComment(id);

        return ResponseEntity.ok(inquire);
    }

    //일정 아이디를 기준으로 댓글 전체 조회
    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<List<CommentResponseDto>> inquereComments(@PathVariable(name = "scheduleId") Long scheduleId) {
        List<CommentResponseDto> inquires = commentService.inquireComments(scheduleId);

        return ResponseEntity.ok(inquires);
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> upgradeComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto) {
        CommentResponseDto upgradeComment = commentService.upgradeComment(commentId, requestDto);
        return ResponseEntity.ok(upgradeComment);
    }

    //댓글 삭제
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}
