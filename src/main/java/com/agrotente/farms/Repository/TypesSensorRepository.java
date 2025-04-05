package com.agrotente.farms.Repository;

import com.agrotente.farms.model.TypesSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesSensorRepository extends JpaRepository<TypesSensor, Long> {
}