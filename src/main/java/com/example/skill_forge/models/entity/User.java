package com.example.skill_forge.models.entity;

import com.example.skill_forge.models.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "user_username", length = 50, nullable = false)
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_email", unique = true)
    private String email;

    @Column(name = "user_enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "user_objectives")
    @OneToMany(mappedBy = "user")
    private Set<Objective> objectives;

    @Column(name = "user_sessions")
    @OneToMany(mappedBy = "user")
    private Set<Session> sessions;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    @CollectionTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id") // Spécifiez ici le nom de la colonne faisant référence à la clé primaire de l'entité parente
    )
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
