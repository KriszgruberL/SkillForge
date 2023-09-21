package com.example.skill_forge.config;

import com.example.skill_forge.jwt.JWTFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
//@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    // This configuration class defines security-related beans and settings for your Spring Security configuration.

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JWTFilter jwtFilter) throws Exception {
        http
                .csrf((customizer) -> customizer.disable())
                .httpBasic(AbstractHttpConfigurer::disable);


        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//        /** : 0 a n segment d'URI
//        /* : 0 a 1 segment d'URI
//        ? : n'importe quel caractère

        http
                .authorizeHttpRequests(registery -> {
                    registery
                            .requestMatchers("/swagger/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                            .requestMatchers("/auth/login", "/auth/register").permitAll()
                            .requestMatchers("**").permitAll();
//                            .requestMatchers(HttpMethod.HEAD).hasRole("ADMIN")
//                            .requestMatchers("/test/header").anonymous()
//                            .requestMatchers(HttpMethod.POST, "/studio/**").hasAuthority("ROLE_USER")
//                            .requestMatchers(request -> request.getParameterMap().size() > 5).authenticated();
                    // todo security this is awful
                });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}