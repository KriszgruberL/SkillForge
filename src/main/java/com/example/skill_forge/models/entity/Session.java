package com.example.skill_forge.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "session")
@Getter @Setter
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id", nullable = false)
    private Long id;

    @Column(name = "session_start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "session_end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "session_days", nullable = false)
    private Set<DayOfWeek> sessionsDays;

    @ManyToOne
    @JoinColumn(name = "session_user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "session_course_id")
    private Course courseId;

    @ManyToOne
    @JoinColumn(name = "session_online_course_id")
    private OnlineCourse onlineCourseId;

}
