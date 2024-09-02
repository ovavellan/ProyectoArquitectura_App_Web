package com.proyect.aeropuerto.services;
import com.proyect.aeropuerto.models.MecanicoModelo;
import com.proyect.aeropuerto.repositories.MecanicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MecanicoService {

    @Autowired
    private MecanicoRepository mecanicoRepository;

    public MecanicoModelo guardarMecanico(MecanicoModelo mecanicoModelo) {
        MecanicoModelo mecanico = new MecanicoModelo();
        mecanico.setNombre(mecanicoModelo.getNombre());
        mecanico.setApellido(mecanicoModelo.getApellido());
        mecanico.setCedula(mecanicoModelo.getCedula());
        mecanico.setEspecialidad(mecanicoModelo.getEspecialidad());
        if (mecanicoModelo.getId() != null) {
            mecanico.setId(mecanicoModelo.getId());
        }
        return mecanicoRepository.save(mecanico);
    }

    public Optional<MecanicoModelo> obtenerMecanicoPorId(Long id) {
        return mecanicoRepository.findById(id);
    }

    public List<MecanicoModelo> obtenerTodosLosMecanicos() {
        return mecanicoRepository.findAll();
    }

    public MecanicoModelo actualizarMecanico(Long id, MecanicoModelo mecanicoDetalles) {
        Optional<MecanicoModelo> mecanicoOptional = mecanicoRepository.findById(id);
        if (mecanicoOptional.isPresent()) {
            MecanicoModelo mecanicoExistente = mecanicoOptional.get();
            mecanicoExistente.setNombre(mecanicoDetalles.getNombre());
            mecanicoExistente.setApellido(mecanicoDetalles.getApellido());
            mecanicoExistente.setCedula(mecanicoDetalles.getCedula());
            mecanicoExistente.setEspecialidad(mecanicoDetalles.getEspecialidad());
            return mecanicoRepository.save(mecanicoExistente);
        } else {
            throw new RuntimeException("Mecanico no encontrado con el ID: " + id);
        }
    }
    public void eliminarMecanico(Long id) {

        mecanicoRepository.deleteById(id);
    }
}