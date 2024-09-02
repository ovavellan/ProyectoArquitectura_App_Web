package com.aeropuertomongo.Controlador;

import com.aeropuertomongo.Modelo.mantenimientoModelo;
import com.aeropuertomongo.Modelo.vueloModelo;
import com.aeropuertomongo.Servicio.mantenimientoServicio;
import com.aeropuertomongo.Servicio.vueloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vuelos")
public class vuelosControlador {
    @Autowired
    private vueloServicio vueloServicio;

    @GetMapping(value = "/", produces = "application/json")
    public List<vueloModelo> obtenerTodos() {
        return vueloServicio.obtenerTodosVuelos();
    }

    @PostMapping("/")
    public vueloModelo crear(@RequestBody vueloModelo vueloModelo) {
        return vueloServicio.crear(vueloModelo);
    }

    @PutMapping("/{id}")
    public vueloModelo actualizar(@PathVariable String id, @RequestBody vueloModelo vuelo) {
        return vueloServicio.actualizar(id, vuelo);
    }

    @DeleteMapping("/{id}")
    public List<String> eliminar(@PathVariable String id) {
        List<String> resultado = new ArrayList<>();
        vueloServicio.eliminar(id);
        resultado.add(id);
        return resultado;
    }

    @DeleteMapping("/todos/{id_avion}")
    public List<Long> eliminarPorAvion(@PathVariable String id_avion) {
        List<Long> resultado = new ArrayList<>();
        long eliminados = vueloServicio.eliminarVuelosPorAvion(id_avion);
        resultado.add(eliminados);
        return resultado;
    }


}