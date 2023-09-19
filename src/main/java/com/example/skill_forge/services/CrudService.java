package com.example.skill_forge.services;


import java.util.List;

public interface CrudService<T, ID> {
    // Create
    ID add(T entity);
    // Read
    List<T> getAll();
    T getOne(ID id);
    // Update
    T update(ID id, T entity);
    // Delete
    void delete(ID id);
}