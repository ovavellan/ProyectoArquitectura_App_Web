package com.aeropuertomongo.Controlador;

import com.aeropuertomongo.Modelo.mecanicoModelo;
import com.aeropuertomongo.Servicio.mecanicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mecanicos")
public class mecanicoControlador {
    @Autowired
    private mecanicoServicio mecanicoService;

    @GetMapping("/")
    public List<mecanicoModelo> obtenerTodosLosMecanicos() {
        return mecanicoService.obtenerTodosLosMecanicos();
    }

    @GetMapping("/{id}")
    public Optional<mecanicoModelo> obtenerMecanicoPorId(@PathVariable String id) {
        return mecanicoService.obtenerMecanicoPorId(id);
    }

    @PostMapping("/")
    public mecanicoModelo crearMecanico(@RequestBody mecanicoModelo mecanico) {
        return mecanicoService.crearMecanico(mecanico);
    }

    @PutMapping("/{id}")
    public mecanicoModelo actualizarMecanico(@PathVariable String id, @RequestBody mecanicoModelo mecanico) {
        return mecanicoService.actualizarMecanico(id, mecanico);
    }

    @DeleteMapping("/{id}")
    public void eliminarMecanico(@PathVariable String id) {
        mecanicoService.eliminarMecanico(id);
    }
}