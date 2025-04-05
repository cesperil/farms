package com.agrotente.farms.service;

import com.agrotente.farms.model.Farm;
import com.agrotente.farms.model.Harvest;
import com.agrotente.farms.Repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HarvestService {

    @Autowired
    private HarvestRepository harvestRepository;

    public Harvest saveOrUpdateHarvest(Harvest harvest) {
        return harvestRepository.save(harvest);
    }

    public Optional<Harvest> getHarvestById(Long id) {
        return harvestRepository.findById(id);
    }

    public List<Harvest> getAllHarvests() {
        return harvestRepository.findAll();
    }

    public void deleteHarvestById(Long id) {
        harvestRepository.deleteById(id);
    }

    public List<Harvest> getHarvestsByIdParcela(Farm idParcela) {
        return harvestRepository.findByIdParcela(idParcela);
    }



}