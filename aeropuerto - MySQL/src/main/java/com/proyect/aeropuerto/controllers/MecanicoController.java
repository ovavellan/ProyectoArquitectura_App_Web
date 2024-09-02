package com.proyect.aeropuerto.controllers;

import com.proyect.aeropuerto.models.MecanicoModelo;
import com.proyect.aeropuerto.services.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mecanicos")
public class MecanicoController {

    @Autowired
    private MecanicoService mecanicoService;

    // Crear un nuevo MecanicoModelo
    @PostMapping
    public ResponseEntity<MecanicoModelo> crearMecanico(@RequestBody MecanicoModelo mecanicoModelo) {
        MecanicoModelo nuevoMecanico = mecanicoService.guardarMecanico(mecanicoModelo);
        return new ResponseEntity<>(nuevoMecanico, HttpStatus.CREATED);
    }

    // Obtener todos los MecanicoModelo
    @GetMapping
    public ResponseEntity<List<MecanicoModelo>> obtenerTodosLosMecanicos() {
        List<MecanicoModelo> mecanicos = mecanicoService.obtenerTodosLosMecanicos();
        return new ResponseEntity<>(mecanicos, HttpStatus.OK);
    }

    // Obtener un MecanicoModelo por ID
    @GetMapping("/{id}")
    public ResponseEntity<MecanicoModelo> obtenerMecanicoPorId(@PathVariable Long id) {
        Optional<MecanicoModelo> mecanico = mecanicoService.obtenerMecanicoPorId(id);
        if (mecanico.isPresent()) {
            return new ResponseEntity<>(mecanico.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un MecanicoModelo existente
    @PutMapping("/{id}")
    public ResponseEntity<MecanicoModelo> actualizarMecanico(@PathVariable Long id, @RequestBody MecanicoModelo mecanicoDetalles) {
        try {
            MecanicoModelo mecanicoActualizado = mecanicoService.actualizarMecanico(id, mecanicoDetalles);
            return new ResponseEntity<>(mecanicoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un MecanicoModelo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMecanico(@PathVariable Long id) {
        try {
            mecanicoService.eliminarMecanico(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
