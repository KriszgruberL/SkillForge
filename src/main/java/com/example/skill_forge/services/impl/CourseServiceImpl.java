package com.example.skill_forge.services.impl;

import com.example.skill_forge.models.entity.Course;
import com.example.skill_forge.repositories.CourseRepository;
import com.example.skill_forge.services.CourseService;
import com.example.skill_forge.services.InstitutionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    private Course escapeSingleQuotesInCourse(Course course) {
        // Escape single quotes in string fields of the Course entity
        course.setName(escapeSingleQuotes(course.getName()));
        course.setTeacher(escapeSingleQuotes(course.getTeacher()));
        course.setProgram(escapeSingleQuotes(course.getProgram()));
        course.setTerminalCapacities(escapeSingleQuotes(course.getTerminalCapacities()));

        return course;
    }

    private String escapeSingleQuotes(String input) {
        if (input != null) {
            return input.replace("'", "\\'");
        }
        return input;
    }

    @Override
    public Long add(Course entity) {
        if (courseRepository.existsByName(entity.getName())) {
            throw new RuntimeException("Already exist");
            // todo exception already exist
        }
        if (courseRepository.existsByUeCode(entity.getName())) {
            throw new RuntimeException("Already exist");
            // todo exception already exist
        }
        entity = escapeSingleQuotesInCourse(entity);
        return courseRepository.save(entity).getId();
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getOne(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        //todo notfound exception
    }

    @Override
    public Course update(Long id, Course update) {
        Course entity = getOne(id);

        entity.setName(update.getName());
        entity.setTeacher(update.getTeacher());
        entity.setStartDate(update.getStartDate());
        entity.setEndDate(update.getEndDate());
        entity.setUeCode(update.getUeCode());
        entity.setInstitutionId(update.getInstitutionId());

        return courseRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        courseRepository.delete(getOne(id));
    }
}
