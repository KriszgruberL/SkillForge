package com.example.skill_forge.models.forms;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {

    @NotBlank
    private String username;
//
//    @NotBlank
//    private String email;

    @NotBlank
    private String password;
}
