package com.agrotente.farms;

import com.agrotente.farms.controller.FarmsController;
import com.agrotente.farms.model.Farm;
import com.agrotente.farms.service.FarmsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(FarmsController.class)
public class FarmsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FarmsService farmsService;

    @Autowired
    private ObjectMapper objectMapper;

    private Farm farm;

    @BeforeEach
    void setUp() {
        farm = new Farm();
        farm.setId(Math.toIntExact(3L));
        farm.setNombre("Parcela 1");
        farm.setFkIdeUsuario(1);
        // Configurar otros campos de la parcela
    }

    @Test
    void testGetAllFarms() throws Exception {
        Mockito.when(farmsService.getAllFarms()).thenReturn(Arrays.asList(farm));

        mockMvc.perform(get("/api/farms"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(farm.getId()))
                .andExpect(jsonPath("$[0].nombre").value(farm.getNombre()));
    }

    @Test
    void testGetFarmsByIdUsuario() throws Exception {
        Mockito.when(farmsService.getAllFarms()).thenReturn(Arrays.asList(farm));

        mockMvc.perform(get("/api/farms/by-user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fkideusuario").value(farm.getFkIdeUsuario()));
    }

/*
    @Test
    void testGetById() throws Exception {
        Mockito.when(farmsService.getFarmById((int) anyLong())).thenReturn(Optional.ofNullable(farm));

        mockMvc.perform(get("/api/farms/{id}", 3))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(farm.getId()))
                .andExpect(jsonPath("$.nombre").value(farm.getNombre()));
    }

    @Test
    void testCreateParcela() throws Exception {
        Mockito.when(farmsService.saveOrUpdateFarm((any(Farm.class)))).thenReturn(farm);


        mockMvc.perform(post("/api/farms/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(farm)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(farm.getId()))
                .andExpect(jsonPath("$.nombre").value(farm.getNombre()));
    }



    @Test
    void testDeleteParcela() throws Exception {
        doNothing().when(farmsService).deleteFarmById((int) anyLong());

        mockMvc.perform(delete("/api/farms/{id}", 1L))
                .andExpect(status().isNoContent());
    }

 */
}
