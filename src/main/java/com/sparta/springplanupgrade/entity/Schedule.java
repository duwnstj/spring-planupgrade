package com.sparta.springplanupgrade.entity;

import com.sparta.springplanupgrade.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "scedules")
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;


    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "schedule")
    private List<Comment> comments;


    public Schedule(ScheduleRequestDto scheduleRequestDto) {
        this.userName = scheduleRequestDto.getUserName();
        this.content = scheduleRequestDto.getContent();
        this.title = scheduleRequestDto.getTitle();
    }
}
