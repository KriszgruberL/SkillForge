package com.example.skill_forge.services;

import com.example.skill_forge.models.entity.Course;
import com.example.skill_forge.models.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService extends CrudService<Course, Long> {

    Page<Course> getAllByUser(User user, Integer page, Integer size);
    Long getCount(User user);

}