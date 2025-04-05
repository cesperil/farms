package com.agrotente.farms.Repository;

import com.agrotente.farms.model.Farm;
import com.agrotente.farms.model.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HarvestRepository extends JpaRepository<Harvest, Long> {

    List<Harvest> findByIdParcela(Farm idParcela);
}