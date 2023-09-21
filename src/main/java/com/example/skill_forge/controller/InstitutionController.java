package com.example.skill_forge.controller;

import com.example.skill_forge.models.dtos.InstitutionDTO;
import com.example.skill_forge.models.entity.Address;
import com.example.skill_forge.models.entity.Institution;
import com.example.skill_forge.models.forms.InstitutionForm;
import com.example.skill_forge.services.InstitutionService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

 @CrossOrigin("*")
@RestController
@RequestMapping("/institution")
public class InstitutionController {

    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @ApiResponse(
            description = "Retourne tous les établissements"
    )
    @GetMapping
    public ResponseEntity<List<InstitutionDTO>> getAll() {

        return ResponseEntity.ok(
                institutionService.getAll()
                        .stream()
                        .map(InstitutionDTO::toDTO)
                        .toList()
        );
    }

    @ApiResponse(
            description = "Retourne un établissement dont l'id est passé en path variable"
    )
    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<InstitutionDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(InstitutionDTO.toDTO(institutionService.getOne(id)));
    }


    @ApiResponse(
            description = "Ajoute un établissement "
    )
    @PostMapping
    public ResponseEntity<Long> addInstitution(@RequestBody @Valid InstitutionForm form) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(institutionService.add(form.toEntity()));
    }

    @ApiResponse(
            description = "Supprime un établissement "
    )

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> deleteInstitution(@PathVariable long id) {
        institutionService.delete(id);

        return ResponseEntity.noContent().build();
    }


    @ApiResponse(
            description = "Update un établissement "
    )
    @PatchMapping("/{id:[0-9]+}")
    public ResponseEntity<InstitutionDTO> updateInstitution(@PathVariable long id, @RequestBody @Valid InstitutionForm form) {

        Institution institution = institutionService.update(id, form.toEntity());
        InstitutionDTO body = InstitutionDTO.toDTO(institution);

        return ResponseEntity.ok(body);
    }
}
