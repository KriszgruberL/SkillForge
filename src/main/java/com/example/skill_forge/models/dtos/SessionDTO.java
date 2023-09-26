package com.example.skill_forge.models.dtos;

import com.example.skill_forge.models.entity.Session;
import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Data
@Builder
public class SessionDTO {

    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private Set<DayOfWeek> days;

    public static SessionDTO toDTO(Session entity) {

        if (entity == null) {
            return null;
        }

        return SessionDTO.builder()
                .id(entity.getId())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .days(entity.getSessionsDays())
                .build();
    }


}
