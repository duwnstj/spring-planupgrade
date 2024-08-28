package com.sparta.springplanupgrade.entity;

import com.sparta.springplanupgrade.dto.CommentRequestDto;
import com.sparta.springplanupgrade.dto.CommentResponseDto;
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

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;


    public Comment(CommentRequestDto commentRequestDto, Schedule scuedule) {
        this.userName = commentRequestDto.getUserName();
        this.content = commentRequestDto.getContent();
        this.schedule = scuedule;
    }
}
