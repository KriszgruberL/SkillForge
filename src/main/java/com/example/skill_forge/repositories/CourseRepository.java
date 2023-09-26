package com.example.skill_forge.repositories;

import com.example.skill_forge.models.entity.Course;
import com.example.skill_forge.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CourseRepository extends JpaRepository<Course, Long> {

    boolean existsByName(String name);
    boolean existsByUeCode(String ueCode);

    @Query("SELECT c FROM Course c JOIN c.sessions s JOIN s.user u WHERE u = ?1")
    Set<Course> getCoursesByUser(User user);

    @Query("SELECT COUNT(c) FROM Course c JOIN c.sessions s JOIN s.user u WHERE u = ?1")
    Long getCourseCount(User user);
}
