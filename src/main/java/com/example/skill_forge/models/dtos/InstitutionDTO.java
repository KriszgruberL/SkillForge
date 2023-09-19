package com.example.skill_forge.models.dtos;

import com.example.skill_forge.models.entity.Institution;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class InstitutionDTO {

    private Long id;
    private String name;
    private AddressDTO address;
    private Set<CourseDTO> coursesGiven;

    public static InstitutionDTO toDTO(Institution entity){
        if(entity == null) {
            return null;
        }

        return InstitutionDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(AddressDTO.toDTO(entity.getAddress()))
                .coursesGiven(entity.getCoursesGiven()
                        .stream()
                        .map(CourseDTO :: toDTO)
                        .collect(Collectors.toSet()))
                .build();
    }
}
