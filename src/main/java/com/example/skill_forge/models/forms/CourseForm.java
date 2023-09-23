package com.example.skill_forge.models.forms;

import com.example.skill_forge.models.entity.Course;
import com.example.skill_forge.models.entity.Session;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class CourseForm {

    private String name;
    private String ueCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private String teacher;
    private String program;
    private String terminalCapacities;


    private Long institutionId;

    public Course toEntity() {
        Course course = new Course();
        course.setName(this.name);
        course.setUeCode(this.ueCode);
        course.setStartDate(this.startDate);
        course.setEndDate(this.endDate);
        course.setTeacher(this.teacher);
        course.setProgram(this.program);
        course.setTerminalCapacities(this.terminalCapacities);

        return course;
    }
}
