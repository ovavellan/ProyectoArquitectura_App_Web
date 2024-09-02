package com.proyect.aeropuerto.controllers;

import com.proyect.aeropuerto.models.MantenimientoModelo;
import com.proyect.aeropuerto.models.MecanicoModelo;
import com.proyect.aeropuerto.services.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoController {
    @Autowired
    private MantenimientoService mantenimientoService;

    @PostMapping
    public ResponseEntity<MantenimientoModelo> crearMantenimiento(@RequestBody MantenimientoModelo mantenimientoModelo) {
        MantenimientoModelo nuevoMecanico = mantenimientoService.guardarMantenimiento(mantenimientoModelo);
        return new ResponseEntity<>(nuevoMecanico, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MantenimientoModelo>> obtenerTodosLosMecanicos() {
        List<MantenimientoModelo> mantenimiento = mantenimientoService.obtenerTodosLosMantenimiento();
        return new ResponseEntity<>(mantenimiento, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MantenimientoModelo> obtenerMantenimientoPorId(@PathVariable Long id) {
        Optional<MantenimientoModelo> mantenimiento = mantenimientoService.obtenerMantenimientoPorId(id);
        if (mantenimiento.isPresent()) {
            return new ResponseEntity<>(mantenimiento.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MantenimientoModelo> actualizarMecanico(@PathVariable Long id, @RequestBody MantenimientoModelo mantenimientoDetalles) {
        try {
            MantenimientoModelo mantenimientoActualizado = mantenimientoService.actualizarMantenimiento(id, mantenimientoDetalles);
            return new ResponseEntity<>(mantenimientoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMecanico(@PathVariable Long id) {
        try {
            mantenimientoService.eliminarMantenimiento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
