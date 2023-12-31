package com.example.skill_forge.models.forms;

import com.example.skill_forge.models.entity.User;
import com.example.skill_forge.models.entity.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
public class RegisterForm {

    @NotBlank
    private String username;

    @Email
    private String email;

    @NotBlank
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*[!=@#|$%^&*()_+{}\\\\[\\\\]:;<>,.?~\\\\-]).*(?=.*[A-Z]).*(?=.*[0-9]).*$")
    private String password;

    public User toEntity(){
        User entity = new User();

        entity.setUsername(username);
        entity.setEmail(email);
        entity.setPassword(password);
        return entity;
    }
}
