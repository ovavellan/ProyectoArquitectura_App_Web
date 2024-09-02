package com.proyect.aeropuerto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.proyect.aeropuerto.models.PilotoModelo;
import com.proyect.aeropuerto.services.PilotoService;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

	@Autowired
	private PilotoService pilotoService;

	@GetMapping()
	public List<PilotoModelo> getAll() {
		return pilotoService.getAll();
	}

	@PostMapping()
	public Map<String, Object> create(@RequestBody PilotoModelo pilotoModelo) {
		try {
			pilotoService.save(pilotoModelo);
			return Map.of("result", true, "message", "Piloto agregado correctamente");
		} catch (Exception e) {
			return Map.of("result", false, "message", "Error: No se ha podido agregar al piloto");
		}
	}

	@PutMapping("/{pilotoId}")
	public Map<String, Object> update(@PathVariable Long pilotoId, @RequestBody PilotoModelo pilotoModelo) {
		try {
			if (pilotoService.update(pilotoId, pilotoModelo)) {
				return Map.of("result", true, "message", "Piloto modificado correctamente");
			} else {
				return Map.of("result", false, "message", "No existe piloto con ese id");
			}
		} catch (Exception e) {
			return Map.of("result", false, "message", "Error: No se ha podido modificar al piloto");
		}
	}

	@DeleteMapping("/{pilotoId}")
	public Map<String, Object> delete(@PathVariable Long pilotoId) {
		try {
			if (pilotoService.delete(pilotoId)) {
				return Map.of("result", true, "message", "Piloto eliminado correctamente");
			} else {
				return Map.of("result", false, "message", "No existe piloto con ese id");
			}
		} catch (Exception e) {
			return Map.of("result", false, "message", "Error: No se ha podido eliminar al piloto. Hay aviones vinculados");
		}
	}
}
