package com.example.skill_forge.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long id;

    @Column(name = "course_name", nullable = false)
    private String name;

    @Column(name = "course_ue_code")
    private String ue_code;

    @Column(name = "course_start_date", nullable = false)
    private LocalDate start_date;

    @Column(name = "course_end_date", nullable = false)
    private LocalDate end_date;

    @Column(name = "course_teacher")
    private String teacher;

    @OneToMany(mappedBy = "course_id")
    private Set<Session> sessions;

    @ManyToMany
    private Set<Task> tasks;

    @ManyToOne
    private Institution institution_id;


}
