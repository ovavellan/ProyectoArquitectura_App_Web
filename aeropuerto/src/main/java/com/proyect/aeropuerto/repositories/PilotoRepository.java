package com.proyect.aeropuerto.repositories;

import java.util.ArrayList;
import java.util.List;

import com.proyect.aeropuerto.models.PilotoModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotoRepository extends JpaRepository<PilotoModelo, Long> {
    PilotoModelo findByNameAndLastname(String name, String lastname);
}
