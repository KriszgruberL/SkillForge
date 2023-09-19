package com.example.skill_forge.services.impl;

import com.example.skill_forge.models.entity.Address;
import com.example.skill_forge.models.entity.Institution;
import com.example.skill_forge.repositories.AddressRepository;
import com.example.skill_forge.repositories.InstitutionRepository;
import com.example.skill_forge.services.InstitutionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;
    private final AddressRepository addressRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository, AddressRepository addressRepository) {
        this.institutionRepository = institutionRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public Long add(Institution entity) {

        if (institutionRepository.existsByName(entity.getName())) {
            throw new RuntimeException("Already exist");
            // todo exception already exist
        }

        return institutionRepository.save(entity).getId();
    }

    @Override
    public List<Institution> getAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution getOne(Long id) {
        return institutionRepository.findById(id).orElseThrow(() -> new RuntimeException("Institution not found"));
        //todo exception notfound
    }

    @Override
    public Institution update(Long id, Institution update) {
        Institution entity = getOne(id);

        entity.setName(update.getName());

        if (!entity.getAddress().equals(update.getAddress())) {
            entity.setAddress(update.getAddress());
        }

        return institutionRepository.save(entity);

//        update.setId(id);
//        update.setAddress(entity.getAddress());
//
//        return institutionRepository.save(update);
    }


    @Override
    public void delete(Long id) {
        Address address = getOne(id).getAddress();

        institutionRepository.delete(getOne(id));
        addressRepository.delete(address);

    }
}
