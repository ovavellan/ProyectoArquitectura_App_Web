package com.proyect.aeropuerto.repositories;

import com.proyect.aeropuerto.models.MecanicoModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MecanicoRepository extends JpaRepository<MecanicoModelo, Long> {
}
