package com.example.skill_forge.controller;


import com.example.skill_forge.jwt.JWTUtils;
import com.example.skill_forge.models.dtos.AuthDTO;
import com.example.skill_forge.models.entity.User;
import com.example.skill_forge.models.forms.LoginForm;
import com.example.skill_forge.models.forms.RegisterForm;
import com.example.skill_forge.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

//    http://localhost:8080/swagger-ui/index.html#/auth-controller

    private final UserService userService;
    private final UserDetailsService userDetailsService;

    public AuthController(
            UserService userService,
            UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterForm form){
        User user= form.toEntity();
        userService.register( user );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/login")
    public  ResponseEntity<AuthDTO> login (@RequestBody @Valid LoginForm form){

        String token = userService.login((form.getUsername()), form.getPassword());
        User user = (User) userDetailsService.loadUserByUsername( form.getUsername() );

        return ResponseEntity.ok( AuthDTO.toDTO( token, user ) );
    }
}
