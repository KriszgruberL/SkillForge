package com.example.skill_forge.models.dtos;

import com.example.skill_forge.models.entity.Course;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class SmallCourseDTO {

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String teacher;
    private SmallInstitutionDTO institution;


    public static SmallCourseDTO toDTO(Course entity){
        if(entity == null) {
            return null;
        }

        return SmallCourseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .teacher(entity.getTeacher())
                .institution(SmallInstitutionDTO.toDTO(entity.getInstitutionId()))
                .build();
    }
}
