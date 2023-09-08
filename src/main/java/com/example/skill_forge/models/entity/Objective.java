package com.example.skill_forge.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "objectives")
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "objectives_id", nullable = false)
    private Long id;

    @Column(name = "objective_description", length = 500, nullable = false)
    private String description;

    @Column(name = "objective_avancement", nullable = false)
    private String avancement;

    @ManyToOne
    @JoinColumn(name = "objective_user_id")
    private User user;

    @OneToMany(mappedBy = "objective")
    private List<Task> tasks;


}