package com.example.skill_forge.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "session")
@Getter @Setter
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id", nullable = false)
    private Long id;

    @Column(name = "session_start_time", nullable = false)
    private LocalTime start_time;

    @Column(name = "session_end_time", nullable = false)
    private LocalTime end_time;

    @ManyToOne
    @JoinColumn(name = "session_user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "session_course_id")
    private Course course_id;

    @ManyToOne
    @JoinColumn(name = "session_online_course_id")
    private OnlineCourse online_course_id;

}
