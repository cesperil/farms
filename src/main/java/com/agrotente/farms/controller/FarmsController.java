package com.agrotente.farms.controller;

import com.agrotente.farms.model.Farm;
import com.agrotente.farms.service.FarmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/farms")
@CrossOrigin(origins = "http://localhost:65107")
public class FarmsController {

    @Autowired
    private FarmsService farmService;

    // Create or Update
    @PostMapping
    public ResponseEntity<Farm> createOrUpdateFarm(@RequestBody Farm farm) {
        Farm savedFarm = farmService.saveOrUpdateFarm(farm);
        return ResponseEntity.ok(savedFarm);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarmById(@PathVariable Integer id) {
        Optional<Farm> farm = farmService.getFarmById(id);
        return farm.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<Farm>> getAllFarms() {
        List<Farm> farms = farmService.getAllFarms();
        return ResponseEntity.ok(farms);
    }

    // Read by Name
    @GetMapping("/by-name")
    public ResponseEntity<List<Farm>> getFarmsByName(@RequestParam String nombre) {
        List<Farm> farms = farmService.getFarmsByName(nombre);
        return ResponseEntity.ok(farms);
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmById(@PathVariable Integer id) {
        farmService.deleteFarmById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-user")
    public ResponseEntity<List<Farm>> getFarmsByName(@RequestParam Integer user) {
        List<Farm> farms = farmService.getFarmByIdUsuario(user);
        return ResponseEntity.ok(farms);
    }
}
