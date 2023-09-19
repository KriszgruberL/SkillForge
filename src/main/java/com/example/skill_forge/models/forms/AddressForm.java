package com.example.skill_forge.models.forms;

import com.example.skill_forge.models.entity.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressForm {

    @NotBlank
    private String street;

    @NotBlank
    @Pattern(regexp = "^[0-9]+[A-Za-z]{0,1}$")
    private String number;

    private String additionnal;

    @NotBlank
    private String city;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String country;


    public Address toEntity() {
        Address address = new Address();
        address.setStreet(this.street);
        address.setNumber(this.number);
        address.setCity(this.city);
        address.setZipcode(this.zipCode);
        address.setAdditional(this.additionnal);
        address.setCountry(this.country);

        return address;
    }
}
