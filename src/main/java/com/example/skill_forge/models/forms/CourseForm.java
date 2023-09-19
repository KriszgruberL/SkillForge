package com.example.skill_forge.models.forms;

import com.example.skill_forge.models.entity.Course;
import com.example.skill_forge.models.entity.Session;

import java.time.LocalDate;
import java.util.Set;

public class CourseForm {

    private String name;
    private String ueCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private String teacher;

    private Set<Session> sessions;
    private InstitutionForm institutionId;

    public Course toEntity() {
        Course course = new Course();
        course.setName(this.name);
        course.setUeCode(this.ueCode);
        course.setStartDate(this.startDate);
        course.setEndDate(this.endDate);
        course.setTeacher(this.teacher);

        return course;
    }
}
