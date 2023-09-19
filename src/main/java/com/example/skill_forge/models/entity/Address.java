package com.example.skill_forge.models.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "address")
@Getter @Setter
@EqualsAndHashCode(of = {"street","number","zipcode","city","country"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "adress_street", nullable = false)
    private String street;

    @Column(name = "adress_number", nullable = false)
    private String number;

    @Column(name = "adress_additional")
    private String additional;

    @Column(name = "adress_zipcode", nullable = false)
    private String zipcode;

    @Column(name = "adress_city", nullable = false)
    private String city;

    @Column(name = "adress_country", nullable = false)
    private String country;
}
