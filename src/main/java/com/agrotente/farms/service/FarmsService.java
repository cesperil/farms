package com.agrotente.farms.service;

import com.agrotente.farms.Repository.FarmsRepository;
import com.agrotente.farms.model.Farm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmsService {

    @Autowired
    private FarmsRepository farmRepository;

    // Create or Update
    public Farm saveOrUpdateFarm(Farm farm) {
        return farmRepository.save(farm);
    }

    // Read by ID
    public Optional<Farm> getFarmById(Integer id) {
        return farmRepository.findById(id);
    }

    // Read all
    public List<Farm> getAllFarms() {
        return farmRepository.findAll();
    }

    // Read by Name
    public List<Farm> getFarmsByName(String nombre) {
        return farmRepository.findByNombre(nombre);
    }

    // Delete by ID
    public void deleteFarmById(Integer id) {
        farmRepository.deleteById(id);
    }
}
