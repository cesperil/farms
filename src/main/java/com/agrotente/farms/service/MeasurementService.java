package com.agrotente.farms.service;

import com.agrotente.farms.model.Measurement;
import com.agrotente.farms.Repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    public Measurement saveOrUpdateMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    public Optional<Measurement> getMeasurementById(Long id) {
        return measurementRepository.findById(id);
    }

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public void deleteMeasurementById(Long id) {
        measurementRepository.deleteById(id);
    }
}