package com.proyect.aeropuerto.controllers;

import com.proyect.aeropuerto.models.AeropuertoModelo;
import com.proyect.aeropuerto.services.AeropuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/aeropuertos")
public class AeropuertoController {
    @Autowired
    private AeropuertoService aeropuertoService;

    @GetMapping()
    public List<AeropuertoModelo> getAll() {
        return aeropuertoService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody AeropuertoModelo aeropuertoModelo) {
        try {
            aeropuertoService.save(aeropuertoModelo);
            return Map.of("result", true, "message", "Aeropuerto agregado correctamente");
        } catch (Exception e) {
            return Map.of("result", false, "message", "Error: No se ha podido agregar el aeropuerto");
        }
    }

    @PutMapping("/{aeropuertoId}")
    public Map<String, Object> update(@PathVariable Long aeropuertoId, @RequestBody AeropuertoModelo aeropuertoModelo) {
        try {
            if (aeropuertoService.update(aeropuertoId, aeropuertoModelo)) {
                return Map.of("result", true, "message", "Aeropuerto modificado correctamente");
            } else {
                return Map.of("result", false, "message", "No existe aeropuerto con ese id");
            }
        } catch (Exception e) {
            return Map.of("result", false, "message", "Error: No se ha podido modificar el aeropuerto");
        }
    }

    @DeleteMapping("/{aeropuertoId}")
    public Map<String, Object> delete(@PathVariable Long aeropuertoId) {
        try {
            if (aeropuertoService.delete(aeropuertoId)) {
                return Map.of("result", true, "message", "Aeropuerto eliminado correctamente");
            } else {
                return Map.of("result", false, "message", "No existe aeropuerto con ese id");
            }
        } catch (Exception e) {
            return Map.of("result", false, "message", "Error: No se ha podido eliminar el aeropuerto");
        }
    }
}
