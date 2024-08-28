package com.sparta.springplanupgrade.repository;

import com.sparta.springplanupgrade.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
