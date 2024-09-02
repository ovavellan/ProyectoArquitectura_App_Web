package com.aeropuertomongo.Controlador;

import com.aeropuertomongo.Modelo.mantenimientoModelo;
import com.aeropuertomongo.Servicio.mantenimientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mantenimientos")
public class mantenimientoControlador {
    @Autowired
    private mantenimientoServicio mantenimientoService;

    @GetMapping("/")
    public List<mantenimientoModelo> obtenerTodosLosMantenimientos() {
        return mantenimientoService.obtenerTodosLosMantenimientos();
    }

    @GetMapping("/{id}")
    public Optional<mantenimientoModelo> obtenerMantenimientoPorId(@PathVariable String id) {
        return mantenimientoService.obtenerMantenimientoPorId(id);
    }

    @PostMapping("/")
    public mantenimientoModelo crearMantenimiento(@RequestBody mantenimientoModelo mantenimiento) {
        return mantenimientoService.crearMantenimiento(mantenimiento);
    }

    @PutMapping("/{id}")
    public mantenimientoModelo actualizarMantenimiento(@PathVariable String id, @RequestBody mantenimientoModelo mantenimiento) {
        return mantenimientoService.actualizarMantenimiento(id, mantenimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminarMantenimiento(@PathVariable String id) {
        mantenimientoService.eliminarMantenimiento(id);
    }


}