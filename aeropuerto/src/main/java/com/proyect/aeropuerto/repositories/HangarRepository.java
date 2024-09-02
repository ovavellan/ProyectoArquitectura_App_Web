package com.proyect.aeropuerto.repositories;

import com.proyect.aeropuerto.models.HangarModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HangarRepository extends JpaRepository<HangarModelo, Long> {
}
