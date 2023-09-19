package com.example.skill_forge.models.forms;

import com.example.skill_forge.models.entity.Institution;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InstitutionForm {

    @NotBlank
    private String name;

    @Valid
    private AddressForm address;


    public Institution toEntity() {
        Institution institution = new Institution();
        institution.setName(this.name);
        institution.setAddress(this.address.toEntity());
        return institution;
    }

}
