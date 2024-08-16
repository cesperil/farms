package com.agrotente.farms.Repository;

import com.agrotente.farms.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmsRepository extends JpaRepository<Farm, Integer> {
    List<Farm> findByNombre(String nombre);
}
