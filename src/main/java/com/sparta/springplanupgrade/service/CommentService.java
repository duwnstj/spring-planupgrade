package com.sparta.springplanupgrade.service;

import com.sparta.springplanupgrade.dto.request.CommentRequestDto;
import com.sparta.springplanupgrade.dto.response.CommentResponseDto;
import com.sparta.springplanupgrade.entity.Comment;
import com.sparta.springplanupgrade.entity.Schedule;
import com.sparta.springplanupgrade.repository.CommentRepository;
import com.sparta.springplanupgrade.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;


    public CommentService(CommentRepository commentRepository, ScheduleRepository scheduleRepository) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Transactional
    // 댓글 저장 로직
    public CommentResponseDto createComment(Long scheduleId, CommentRequestDto commentRequestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("선택한 일정이 없습니다."));
        Comment comment = new Comment(commentRequestDto, schedule);
        Comment saveComment = commentRepository.save(comment);

        return new CommentResponseDto(saveComment);

    }

    //댓글 단건 조회 로직
    public CommentResponseDto inquireComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("선택한 댓글이 없습니다."));
        return new CommentResponseDto(comment);
    }


    // 일정아이디를 기준으로 댓글 전체 검색
    public List<CommentResponseDto> inquireComments(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("선택한 일정을 찾을 수 없습니다"));
        List<Comment> comments = commentRepository.findBySchedule(schedule);
        return comments.stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    // 댓글 수정
    public CommentResponseDto upgradeComment(Long commentId, CommentRequestDto requestDto) {
        Comment updateComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("수정할 댓글이 없습니다."));
        // Comment 엔티티에 수정한 requestDto 반영
        updateComment.update(requestDto);

        // 수정한 requestDto 객체를 데이터베이스에 저장
        Comment saveComment = commentRepository.save(updateComment);

        //저장한 댓글을 기반으로 ResponseDto로 변환해서 리턴
        return new CommentResponseDto(saveComment);

    }

    // 댓글 삭제
    public void deleteComment(Long commentId) {
        Comment findComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("삭제할 댓글이 없습니다."));
        commentRepository.delete(findComment);
    }
}
