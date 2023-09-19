package com.example.skill_forge.services.impl;

import com.example.skill_forge.jwt.JWTUtils;
import com.example.skill_forge.models.entity.User;
import com.example.skill_forge.models.entity.enums.Role;
import com.example.skill_forge.repositories.UserRepository;
import com.example.skill_forge.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(User user) {
        Assert.notNull(user, "User should not be null");

        if ( userRepository.existsByUsername( user.getUsername() ) || userRepository.existsByUsername( user.getEmail() ) ){
            throw new RuntimeException("Username already exist or email already exist");
            //todo exception unique
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRoles(Set.of(Role.USER));

        userRepository.save(user);
    }

    @Override
    public String login(String username, String password) {
        Authentication authenticate = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(username, password) );
        return JWTUtils.generateJwt( authenticate );
    }

    @Override
    public void delete(Long id) {
        User user = getOne(id);
        user.setEnabled( false );
        userRepository.save(user);
    }

    @Override
    public User getOne(Long id) {
        return userRepository.findById(id)
                .filter( User :: isEnabled)
                .orElseThrow( () -> new RuntimeException("User not found"));
        //todo exception RessourceNotFound
    }
}
