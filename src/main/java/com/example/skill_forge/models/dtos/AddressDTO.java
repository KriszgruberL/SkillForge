package com.example.skill_forge.models.dtos;

import com.example.skill_forge.models.entity.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {

    private Long id;
    private String street;
    private String number;
    private String additional;
    private String zipcode;
    private String city;
    private String country;

    public static AddressDTO toDTO(Address entity){
        if(entity == null) {
            return null;
        }

        return AddressDTO.builder()
                .id(entity.getId())
                .street(entity.getStreet())
                .number(entity.getNumber())
                .additional(entity.getAdditional())
                .zipcode(entity.getZipcode())
                .city(entity.getCity())
                .country(entity.getCountry())
                .build();
    }
}
