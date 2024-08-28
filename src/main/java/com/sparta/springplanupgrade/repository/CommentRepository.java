package com.sparta.springplanupgrade.repository;

import com.sparta.springplanupgrade.entity.Comment;
import com.sparta.springplanupgrade.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findBySchedule(Schedule schedule);
}
