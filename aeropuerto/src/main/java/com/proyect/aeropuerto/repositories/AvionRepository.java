package com.proyect.aeropuerto.repositories;

import com.proyect.aeropuerto.models.AvionModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<AvionModelo, Long> {
}
