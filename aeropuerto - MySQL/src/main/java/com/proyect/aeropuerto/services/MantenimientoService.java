package com.proyect.aeropuerto.services;

import com.proyect.aeropuerto.models.MantenimientoModelo;
import com.proyect.aeropuerto.models.MecanicoModelo;
import com.proyect.aeropuerto.repositories.MantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MantenimientoService {
    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    public MantenimientoModelo guardarMantenimiento(MantenimientoModelo mantenimientoModelo) {
        return mantenimientoRepository.save(mantenimientoModelo);
    }

    public Optional<MantenimientoModelo> obtenerMantenimientoPorId(Long id) {
        return mantenimientoRepository.findById(id);
    }

    public List<MantenimientoModelo> obtenerTodosLosMantenimiento() {
        return mantenimientoRepository.findAll();
    }

    public MantenimientoModelo actualizarMantenimiento(Long id, MantenimientoModelo mantenimientoDetalles) {
        Optional<MantenimientoModelo> mecanicoOptional = mantenimientoRepository.findById(id);
        if (mecanicoOptional.isPresent()) {
            MantenimientoModelo mantenimientoExistente = mecanicoOptional.get();
            mantenimientoExistente.setFecha(mantenimientoDetalles.getFecha());
            mantenimientoExistente.setDescripcion(mantenimientoDetalles.getDescripcion());
            return mantenimientoRepository.save(mantenimientoExistente);
        } else {
            throw new RuntimeException("Mecanico no encontrado con el ID: " + id);
        }
    }
    public void eliminarMantenimiento(Long id) {
        mantenimientoRepository.deleteById(id);
    }

}
