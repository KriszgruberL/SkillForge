package com.example.skill_forge.repositories;

import com.example.skill_forge.models.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SessionRepository extends JpaRepository<Session, Long> {
}
