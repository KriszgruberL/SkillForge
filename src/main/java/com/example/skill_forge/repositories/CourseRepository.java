package com.example.skill_forge.repositories;

import com.example.skill_forge.models.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    boolean existsByName(String name);
    boolean existsByUeCode(String ueCode);
}
