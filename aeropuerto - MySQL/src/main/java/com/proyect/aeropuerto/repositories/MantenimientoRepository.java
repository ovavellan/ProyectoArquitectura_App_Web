package com.proyect.aeropuerto.repositories;

import com.proyect.aeropuerto.models.MantenimientoModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MantenimientoRepository extends JpaRepository<MantenimientoModelo, Long> {
}
