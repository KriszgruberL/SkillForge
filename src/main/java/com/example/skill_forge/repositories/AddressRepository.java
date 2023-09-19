package com.example.skill_forge.repositories;

import com.example.skill_forge.models.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
