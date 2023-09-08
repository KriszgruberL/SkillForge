package com.example.skill_forge.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "log_creation_date", nullable = false)
    private LocalDateTime creation_date;

    @Column(name = "log_content", nullable = false)
    private String content;

    @ManyToMany
    private Set<Skill> skills;

}
