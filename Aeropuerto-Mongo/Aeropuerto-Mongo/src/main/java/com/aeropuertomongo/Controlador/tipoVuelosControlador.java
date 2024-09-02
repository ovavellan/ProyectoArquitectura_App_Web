package com.aeropuertomongo.Controlador;

import com.aeropuertomongo.Modelo.tipoModelo;
import com.aeropuertomongo.Servicio.tipoVueloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tipo_vuelos")
public class tipoVuelosControlador {

    @Autowired
    private tipoVueloServicio tipoVueloServicio;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<tipoModelo>> obtenerTodos() {
        List<tipoModelo> tipos = tipoVueloServicio.obtenerTodosTipos();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<tipoModelo> crearTipoVuelo(@RequestBody tipoModelo tipoVuelo) {
        tipoModelo nuevoTipoVuelo = tipoVueloServicio.crear(tipoVuelo);
        return new ResponseEntity<>(nuevoTipoVuelo, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<tipoModelo> actualizarTipoVuelo(@PathVariable String id, @RequestBody tipoModelo tipoVuelo) {
        tipoModelo tipoVueloActualizado = tipoVueloServicio.actualizar(id, tipoVuelo);
        return new ResponseEntity<>(tipoVueloActualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<String> eliminarTipoVuelo(@PathVariable String id) {
        String tipoVueloEliminado = tipoVueloServicio.eliminar(id);
        return new ResponseEntity<>(tipoVueloEliminado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{tipoId}", produces = "application/json")
    public ResponseEntity<String> eliminarTipoVueloPorId(@PathVariable String tipoId) {
        boolean eliminacionExitosa = tipoVueloServicio.delete(tipoId);
        if (eliminacionExitosa) {
            return new ResponseEntity<>("Tipo de vuelo eliminado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró el tipo de vuelo con el ID proporcionado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{tipoId}")
    public Map<String, Object> delete(@PathVariable String tipoId) {
        try {
            if (tipoVueloServicio.delete(tipoId)) {
                return Map.of("result", true, "message", "Tipo de Vuelo eliminado correctamente");
            } else {
                return Map.of("result", false, "message", "No existe Tipo de vuelo con ese id");
            }
        } catch (Exception e) {
            return Map.of("result", false, "message", "Error: No se ha podido eliminar al Tipo de vuelo");
        }
    }
}
