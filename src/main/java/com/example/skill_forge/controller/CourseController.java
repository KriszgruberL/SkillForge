package com.example.skill_forge.controller;

import com.example.skill_forge.models.dtos.CourseDTO;
import com.example.skill_forge.models.dtos.ListSmallCourseDTO;
import com.example.skill_forge.models.dtos.SmallCourseDTO;
import com.example.skill_forge.models.entity.Course;
import com.example.skill_forge.models.entity.User;
import com.example.skill_forge.models.forms.CourseForm;
import com.example.skill_forge.repositories.UserRepository;
import com.example.skill_forge.services.CourseService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin("*")
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final UserRepository userRepository;

    public CourseController(CourseService courseService,
                            UserRepository userRepository) {
        this.courseService = courseService;
        this.userRepository = userRepository;
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
            description = "Retourne tous les cours par l'utilisateur"
    )
    @GetMapping("/byUser")
//    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ListSmallCourseDTO> getAllByUser(Authentication authentication,
                                                                 @RequestParam(defaultValue = "0", required = false) Integer page,
                                                                 @RequestParam(defaultValue = "2", required = false) Integer size) {
        if (authentication == null) {
            // User is not authenticated, return 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = (User) authentication.getPrincipal();
        ListSmallCourseDTO listSmallCourseDTO = ListSmallCourseDTO.builder()
                .listCourse(courseService.getAllByUser(user, page, size)
                        .stream()
                        .map(SmallCourseDTO::toDTO)
                        .toList())
                .count(courseService.getCount(user))
                .build();

        return ResponseEntity.ok(listSmallCourseDTO);
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
