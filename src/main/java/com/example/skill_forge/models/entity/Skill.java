package com.example.skill_forge.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "skill")
@Getter @Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
    private Long id;

    @Column(name = "skill_name", nullable = false)
    private String name;

    @Column(name = "skill_worked_on_for", nullable = false)
    private String worked_on_for;

    @ManyToMany
    @JoinTable(name = "skill_tasks",
            joinColumns = @JoinColumn(name = "skill_skill_id"),
            inverseJoinColumns = @JoinColumn(name = "tasks_id"))
    private Set<Task> tasks = new LinkedHashSet<>();

}
