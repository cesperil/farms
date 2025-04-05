package com.agrotente.farms.controller;

import com.agrotente.farms.model.TypesSensor;
import com.agrotente.farms.service.TypesSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/types-sensors")
@CrossOrigin(origins = "http://localhost:65107")
public class TypesSensorController {

    @Autowired
    private TypesSensorService typesSensorService;

    @PostMapping
    public ResponseEntity<TypesSensor> createOrUpdateTypesSensor(@RequestBody TypesSensor typesSensor) {
        TypesSensor savedTypesSensor = typesSensorService.saveOrUpdateTypesSensor(typesSensor);
        return ResponseEntity.ok(savedTypesSensor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypesSensor> getTypesSensorById(@PathVariable Long id) {
        Optional<TypesSensor> typesSensor = typesSensorService.getTypesSensorById(id);
        return typesSensor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping
    public ResponseEntity<List<TypesSensor>> getAllTypesSensors() {
        List<TypesSensor> typesSensors = typesSensorService.getAllTypesSensors();
        return ResponseEntity.ok(typesSensors);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypesSensorById(@PathVariable Long id) {
        typesSensorService.deleteTypesSensorById(id);
        return ResponseEntity.noContent().build();
    }
}