package com.agrotente.farms.service;

import com.agrotente.farms.model.TypesSensor;
import com.agrotente.farms.Repository.TypesSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypesSensorService {

    @Autowired
    private TypesSensorRepository typesSensorRepository;

    public TypesSensor saveOrUpdateTypesSensor(TypesSensor typesSensor) {
        return typesSensorRepository.save(typesSensor);
    }

    public Optional<TypesSensor> getTypesSensorById(Long id) {
        return typesSensorRepository.findById(id);
    }

    public List<TypesSensor> getAllTypesSensors() {
        return typesSensorRepository.findAll();
    }

    public void deleteTypesSensorById(Long id) {
        typesSensorRepository.deleteById(id);
    }
}