package com.example.skill_forge.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "online_course")
@Getter
@Setter
public class OnlineCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "online_course_id", nullable = false)
    private Long id;

    @Column(name = "online_course_name", nullable = false)
    private String name;

    @Column(name = "online_course_url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "online_course_platform_id")
    private Platform platform;

    @OneToMany(mappedBy = "online_course_id")
    private Set<Session> sessions;

    @ManyToMany
    private Set<Task> tasks;



}
