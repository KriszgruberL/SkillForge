package com.example.skill_forge.repositories;

import com.example.skill_forge.models.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {

    boolean existsByName(String name);
}
