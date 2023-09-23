package com.example.skill_forge.models.dtos;

import com.example.skill_forge.models.entity.Course;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class CourseDTO {

    private Long id;
    private String name;
    private String ueCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private String teacher;
    private Set<SessionDTO> sessions;
    private String program;
    private String terminalCapacities;
    private SmallInstitutionDTO institution;


    public static CourseDTO toDTO(Course entity){
        if(entity == null) {
            return null;
        }

        return CourseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .ueCode(entity.getUeCode())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .teacher(entity.getTeacher())
                .sessions( entity.getSessions()
                        .stream()
                        .map(SessionDTO::toDTO)
                        .collect(Collectors.toSet()))
                .program(entity.getProgram())
                .terminalCapacities(entity.getTerminalCapacities())
                .institution(SmallInstitutionDTO.toDTO(entity.getInstitutionId()))
                .build();
    }
}
