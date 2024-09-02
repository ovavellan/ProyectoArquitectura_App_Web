package com.proyect.aeropuerto.controllers;

import com.proyect.aeropuerto.DTO.AvionDTO;
import com.proyect.aeropuerto.DTO.AvionPilotoDTO;
import com.proyect.aeropuerto.models.AvionModelo;
import com.proyect.aeropuerto.models.PilotoModelo;
import com.proyect.aeropuerto.services.AvionService;
import com.proyect.aeropuerto.services.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/aviones")
public class AvionController {
    @Autowired
    private AvionService avionService;

    @PostMapping
    public ResponseEntity<AvionModelo> ingresarAvion(@RequestBody AvionDTO avionDTO) {
        AvionModelo nuevoAvion = avionService.ingresarAvion(avionDTO);
        return new ResponseEntity<>(nuevoAvion, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvionModelo> obtenerAvionPorId(@PathVariable Long id) {
        Optional<AvionModelo> avion = avionService.obtenerAvionPorId(id);
        return avion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<AvionPilotoDTO>> obtenerTodos() {
        List<AvionPilotoDTO> aviones = avionService.obtenerTodos();
        return new ResponseEntity<>(aviones, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvionModelo> actualizarAvion(@PathVariable Long id, @RequestBody AvionDTO avionDTO) {
        AvionModelo avionActualizado = avionService.actualizarAvion(id, avionDTO);
        if (avionActualizado != null) {
            return new ResponseEntity<>(avionActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> eliminarAvion(@PathVariable Long id) {
        Long deletedId = avionService.eliminarAvion(id);
        return new ResponseEntity<>(deletedId, HttpStatus.OK);
    }
}
