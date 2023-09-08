package com.example.skill_forge.services;

import com.example.skill_forge.models.entity.User;

public interface UserService {

    void register(User user);
    String login (String username, String password);
}
