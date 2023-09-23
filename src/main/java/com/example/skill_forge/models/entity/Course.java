package com.example.skill_forge.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private String ueCode;

    @Column(name = "course_start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "course_end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "course_program", length = 4000)
    private String program;

    @Column(name = "course_terminal_capacities", length = 1500)
    private String terminalCapacities;

    @Column(name = "course_teacher")
    private String teacher;

    @OneToMany(mappedBy = "courseId")
    private Set<Session> sessions;

    @ManyToMany (cascade = CascadeType.ALL)
    private Set<Task> tasks;

    @ManyToOne
    private Institution institutionId;


}
