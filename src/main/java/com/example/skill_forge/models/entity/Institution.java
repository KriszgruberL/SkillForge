package com.example.skill_forge.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "institution")
@Getter @Setter
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "institution_name", nullable = false)
    private String name;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "institutionId", cascade = CascadeType.ALL)
    private Set<Course> coursesGiven;

}
