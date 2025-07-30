package com.agrotente.farms.controller;

import com.agrotente.farms.model.Measurement;
import com.agrotente.farms.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/measurements")
@CrossOrigin(origins = "http://localhost:4200")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @PostMapping
    public ResponseEntity<Measurement> createOrUpdateMeasurement(@RequestBody Measurement measurement) {
        Measurement savedMeasurement = measurementService.saveOrUpdateMeasurement(measurement);
        return ResponseEntity.ok(savedMeasurement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Measurement> getMeasurementById(@PathVariable Long id) {
        Optional<Measurement> measurement = measurementService.getMeasurementById(id);
        return measurement.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping
    public ResponseEntity<List<Measurement>> getAllMeasurements() {
        List<Measurement> measurements = measurementService.getAllMeasurements();
        return ResponseEntity.ok(measurements);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasurementById(@PathVariable Long id) {
        measurementService.deleteMeasurementById(id);
        return ResponseEntity.noContent().build();
    }
}