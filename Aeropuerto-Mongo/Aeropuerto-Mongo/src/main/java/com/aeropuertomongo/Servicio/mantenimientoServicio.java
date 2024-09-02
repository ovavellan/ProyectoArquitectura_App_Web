package com.aeropuertomongo.Servicio;

import com.aeropuertomongo.Modelo.mantenimientoModelo;
import com.aeropuertomongo.Repositorio.mantenimientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class mantenimientoServicio{
    @Autowired
    private mantenimientoRepositorio mantenimientoRepository;

    public List<mantenimientoModelo> obtenerTodosLosMantenimientos() {
        return mantenimientoRepository.findAll();
    }

    public Optional<mantenimientoModelo> obtenerMantenimientoPorId(String id) {
        return mantenimientoRepository.findById(id);
    }


    public mantenimientoModelo crearMantenimiento(mantenimientoModelo mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }

    public mantenimientoModelo actualizarMantenimiento(String id, mantenimientoModelo mantenimiento) {
        mantenimiento.setId(id);
        return mantenimientoRepository.save(mantenimiento);
    }

    public void eliminarMantenimiento(String id) {
        mantenimientoRepository.deleteById(id);
    }
}