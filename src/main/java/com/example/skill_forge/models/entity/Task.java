package com.example.skill_forge.models.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "task_name", nullable = false)
    private String name;

    @Column(name = "task_start", nullable = false)
    private LocalDateTime start;

    @Column(name = "task_end", nullable = false)
    private LocalDateTime end;

    @Column(name = "task_duration")
    private Duration duration;

    @Column(name = "task_progression", nullable = false)
    private Double progression;

    @ManyToOne
    @JoinColumn(name = "task_objectives_id")
    private Objective objective;



}