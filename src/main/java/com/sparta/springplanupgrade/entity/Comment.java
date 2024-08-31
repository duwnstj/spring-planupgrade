package com.sparta.springplanupgrade.entity;

import com.sparta.springplanupgrade.dto.comment.request.CommentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "comments")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheduleId", nullable = false)
    private Schedule schedule;


    public Comment(CommentRequestDto commentRequestDto, Schedule schedule) {
        this.userName = commentRequestDto.getUserName();
        this.content = commentRequestDto.getContent();
        this.schedule = schedule;
    }

    public void update(CommentRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.content = requestDto.getContent();

    }
}
