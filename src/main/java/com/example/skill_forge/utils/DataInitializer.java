package com.example.skill_forge.utils;

import com.example.skill_forge.models.entity.User;
import com.example.skill_forge.models.entity.enums.Role;
import com.example.skill_forge.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DataInitializer implements CommandLineRunner{

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public void run(String... args) throws Exception {

            String pwd = passwordEncoder.encode("Test1234=");

//            User user = new User();
//            user.setUsername("user");
//            user.setPassword(pwd);
//            user.setEmail("user@test.com");
//            user.setEnabled(true);
//            user.setRoles(Collections.singleton(Role.USER));
//            userRepository.save(user);
//
//            User admin = new User();
//            admin.setUsername("admin");
//            admin.setPassword(pwd);
//            admin.setEmail("admin@test.com");
//            admin.setEnabled(true);
//            admin.setRoles(Collections.singleton(Role.ADMIN));
//            userRepository.save(admin);

        }
    }

