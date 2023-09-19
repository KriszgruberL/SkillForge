package com.example.skill_forge.models.dtos;

import com.example.skill_forge.models.entity.OnlineCourse;
import com.example.skill_forge.models.entity.Platform;
import com.example.skill_forge.models.entity.Session;
import com.example.skill_forge.models.entity.Task;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class OnlineCourseDTO {

    private Long id;
    private String name;
    private String url;
    private Platform platform;
    private Set<SessionDTO> sessions;

    public static OnlineCourseDTO toDTO (OnlineCourse entity){

        if(entity == null) {
            return null;
        }

        return OnlineCourseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .url(entity.getUrl())
                .platform(entity.getPlatform())
                .sessions(entity.getSessions()
                        .stream()
                        .map(SessionDTO::toDTO)
                        .collect(Collectors.toSet()))
                .build();
    }


}
