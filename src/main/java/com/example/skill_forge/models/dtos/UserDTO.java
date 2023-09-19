package com.example.skill_forge.models.dtos;

import com.example.skill_forge.models.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;


@Data
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private Set<String> roles;

    public static UserDTO toDTO(User entity){
        if(entity == null) {
            return null;
        }

        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .roles(entity.getRoles()
                        .stream()
                        .map(Enum::name)
                        .collect(Collectors.toSet()))
                .build();
    }
}
