package com.example.skill_forge.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListSmallCourseDTO {

    private List<SmallCourseDTO> listCourse;
    private Long count;
}
