package com.example.skill_forge.models.dtos;

import com.example.skill_forge.models.entity.Session;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class SessionDTO {

    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;

    public static SessionDTO toDTO(Session entity) {

        if (entity == null) {
            return null;
        }

        return SessionDTO.builder()
                .id(entity.getId())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .build();
    }


}
