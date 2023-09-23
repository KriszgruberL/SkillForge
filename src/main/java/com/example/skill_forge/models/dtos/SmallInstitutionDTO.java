package com.example.skill_forge.models.dtos;

import com.example.skill_forge.models.entity.Institution;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class SmallInstitutionDTO {

    private Long id;
    private String name;
    private AddressDTO address;

    public static SmallInstitutionDTO toDTO(Institution entity){
        if(entity == null) {
            return null;
        }

        return SmallInstitutionDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(AddressDTO.toDTO(entity.getAddress()))
                .build();
    }

}
