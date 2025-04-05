package com.agrotente.farms;

import com.agrotente.farms.controller.HarvestController;
import com.agrotente.farms.model.Farm;
import com.agrotente.farms.model.Harvest;
import com.agrotente.farms.service.HarvestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class HarvestControllerTest {

    @Mock
    private HarvestService harvestService;

    @InjectMocks
    private HarvestController harvestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createOrUpdateHarvest() {
        Harvest harvest = new Harvest();
        when(harvestService.saveOrUpdateHarvest(any(Harvest.class))).thenReturn(harvest);

        ResponseEntity<Harvest> response = harvestController.createOrUpdateHarvest(harvest);

        assertEquals(harvest, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void getHarvestById_found() {
        Harvest harvest = new Harvest();
        when(harvestService.getHarvestById(anyLong())).thenReturn(Optional.of(harvest));

        ResponseEntity<Harvest> response = harvestController.getHarvestById(1L);

        assertEquals(harvest, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void getHarvestById_notFound() {
        when(harvestService.getHarvestById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Harvest> response = harvestController.getHarvestById(1L);

        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    void getAllHarvests() {
        List<Harvest> harvests = Arrays.asList(new Harvest(), new Harvest());
        when(harvestService.getAllHarvests()).thenReturn(harvests);

        ResponseEntity<List<Harvest>> response = harvestController.getAllHarvests();

        assertEquals(harvests, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void deleteHarvestById() {
        doNothing().when(harvestService).deleteHarvestById(anyLong());

        ResponseEntity<Void> response = harvestController.deleteHarvestById(1L);

        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    void getHarvestsByIdParcela() {
        List<Harvest> harvests = Arrays.asList(new Harvest(), new Harvest());
        Farm farm = new Farm();
        when(harvestService.getHarvestsByIdParcela(any(Farm.class))).thenReturn(harvests);

        ResponseEntity<List<Harvest>> response = harvestController.getHarvestsByIdParcela(farm);

        assertEquals(harvests, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }
}
