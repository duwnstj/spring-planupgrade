package com.sparta.springplanupgrade.service;

import com.sparta.springplanupgrade.dto.CommentRequestDto;
import com.sparta.springplanupgrade.dto.CommentResponseDto;
import com.sparta.springplanupgrade.entity.Comment;
import com.sparta.springplanupgrade.entity.Schedule;
import com.sparta.springplanupgrade.repository.CommentRepository;
import com.sparta.springplanupgrade.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private ScheduleRepository scheduleRepository;


    public CommentService(CommentRepository commentRepository, ScheduleRepository scheduleRepository) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public CommentResponseDto createComment(Long scheduleId, CommentRequestDto commentRequestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("선택한 일정이 없습니다."));
        Comment comment = new Comment(commentRequestDto, schedule);
        Comment saveComment = commentRepository.save(comment);

        return new CommentResponseDto(saveComment);

    }
}
