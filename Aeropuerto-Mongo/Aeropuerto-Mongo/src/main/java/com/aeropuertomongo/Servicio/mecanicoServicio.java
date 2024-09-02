package com.aeropuertomongo.Servicio;

import com.aeropuertomongo.Modelo.mecanicoModelo;
import com.aeropuertomongo.Repositorio.mecanicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class mecanicoServicio {
    @Autowired
    private mecanicoRepositorio mecanicoRepository;

    public List<mecanicoModelo> obtenerTodosLosMecanicos() {
        return mecanicoRepository.findAll();
    }

    public Optional<mecanicoModelo> obtenerMecanicoPorId(String id) {
        return mecanicoRepository.findById(id);
    }

    public mecanicoModelo crearMecanico(mecanicoModelo mecanico) {
        return mecanicoRepository.save(mecanico);
    }

    public mecanicoModelo actualizarMecanico(String id, mecanicoModelo mecanico) {
        mecanico.setId(id);
        return mecanicoRepository.save(mecanico);
    }

    public void eliminarMecanico(String id) {
        mecanicoRepository.deleteById(id);
    }
}