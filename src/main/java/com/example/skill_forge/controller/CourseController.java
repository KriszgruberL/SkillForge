package com.example.skill_forge.controller;

import com.example.skill_forge.models.dtos.CourseDTO;
import com.example.skill_forge.models.dtos.SmallCourseDTO;
import com.example.skill_forge.models.entity.Course;
import com.example.skill_forge.models.forms.CourseForm;
import com.example.skill_forge.services.CourseService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("/course")
public class CourseController {
    
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @ApiResponse(
            description = "Retourne tous les cours"
    )
    @GetMapping
    public ResponseEntity<List<SmallCourseDTO>> getAll() {

        return ResponseEntity.ok(
                courseService.getAll()
                        .stream()
                        .map(SmallCourseDTO::toDTO)
                        .toList()
        );
    }


    @ApiResponse(
            description = "Retourne un cours dont l'id est passé en path variable"
    )
    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<CourseDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(CourseDTO.toDTO(courseService.getOne(id)));
    }


    @ApiResponse(
            description = "Ajoute un cours "
    )
    @PostMapping
    public ResponseEntity<Long> addInstitution(@RequestBody @Valid CourseForm form) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(courseService.add(form.toEntity()));
    }

    @ApiResponse(
            description = "Supprime un cours "
    )

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> deleteInstitution(@PathVariable long id) {
        courseService.delete(id);

        return ResponseEntity.noContent().build();
    }


    @ApiResponse(
            description = "Update un cours "
    )
    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<CourseDTO> updateInstitution(@PathVariable long id, @RequestBody @Valid CourseForm form) {

        Course institution = courseService.update(id, form.toEntity());
        CourseDTO body = CourseDTO.toDTO(institution);

        return ResponseEntity.ok(body);
    }
}
