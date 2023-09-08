package com.example.skill_forge.repositories;

import com.example.skill_forge.models.entity.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    User save(User user);

}
