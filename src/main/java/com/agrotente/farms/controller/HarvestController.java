package com.agrotente.farms.controller;

import com.agrotente.farms.model.Farm;
import com.agrotente.farms.model.Harvest;
import com.agrotente.farms.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/harvests")
@CrossOrigin(origins = "http://localhost:4200")
public class HarvestController {

    @Autowired
    private HarvestService harvestService;

    // Create or Update
    @PostMapping
    public ResponseEntity<Harvest> createOrUpdateHarvest(@RequestBody Harvest harvest) {

        // Convert idParcela to Farm object if necessary


        Harvest savedHarvest = harvestService.saveOrUpdateHarvest(harvest);
        return ResponseEntity.ok(savedHarvest);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Harvest> getHarvestById(@PathVariable Long id) {
        Optional<Harvest> harvest = harvestService.getHarvestById(id);
        return harvest.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<Harvest>> getAllHarvests() {
        List<Harvest> harvests = harvestService.getAllHarvests();
        return ResponseEntity.ok(harvests);
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHarvestById(@PathVariable Long id) {
        harvestService.deleteHarvestById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/parcela/{idParcela}")
    public ResponseEntity<List<Harvest>> getHarvestsByIdParcela(@PathVariable Farm idParcela) {
        List<Harvest> harvests = harvestService.getHarvestsByIdParcela(idParcela);
        return ResponseEntity.ok(harvests);
    }

}