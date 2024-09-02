package com.proyect.aeropuerto.services;

import com.proyect.aeropuerto.DTO.AvionPilotoDTO;
import com.proyect.aeropuerto.models.AvionModelo;
import com.proyect.aeropuerto.DTO.AvionDTO;
import com.proyect.aeropuerto.models.PilotoModelo;
import com.proyect.aeropuerto.repositories.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AvionService {

    @Autowired
    private AvionRepository avionRepository;

    public AvionModelo ingresarAvion(AvionDTO avionDTO) {
        AvionModelo avion = new AvionModelo();
        avion.setNombre_aeronave(avionDTO.getNombre_aeronave());
        avion.setCompany(avionDTO.getCompany());
        avion.setCapacidad_pasajeros(avionDTO.getCapacidad_pasajeros());
        avion.setHoras_vuelo(avionDTO.getHoras_vuelo());

        // Asociar el piloto usando el pilotoId
        if (avionDTO.getPilotoId() != null) {
            PilotoModelo piloto = new PilotoModelo();
            piloto.setId(avionDTO.getPilotoId());
            avion.setPilotoModelo(piloto);
        }

        return avionRepository.save(avion);
    }

    public Optional<AvionModelo> obtenerAvionPorId(Long id) {
        return avionRepository.findById(id);
    }

    public List<AvionPilotoDTO> obtenerTodos() {
        List<AvionModelo> aviones = avionRepository.findAll();
        List<AvionPilotoDTO> avionPiloto = new ArrayList<AvionPilotoDTO>();
        for (int i = 0; i < aviones.size(); i++) {
            AvionModelo avion = aviones.get(i);
            AvionPilotoDTO avionPilotoDTO= new AvionPilotoDTO();
            avionPilotoDTO.setAvion(avion);
            avionPilotoDTO.setPiloto(avion.getPilotoModelo());
            avionPiloto.add(avionPilotoDTO);
        }
        return avionPiloto;
    }

    public AvionModelo actualizarAvion(Long id, AvionDTO avionDTO) {
        Optional<AvionModelo> avionExistenteOptional = avionRepository.findById(id);

        if (avionExistenteOptional.isPresent()) {
            AvionModelo avionExistente = avionExistenteOptional.get();
            avionExistente.setNombre_aeronave(avionDTO.getNombre_aeronave());
            avionExistente.setCompany(avionDTO.getCompany());
            avionExistente.setCapacidad_pasajeros(avionDTO.getCapacidad_pasajeros());
            avionExistente.setHoras_vuelo(avionDTO.getHoras_vuelo());

            // Actualizar la asociación con el piloto usando el pilotoId
            if (avionDTO.getPilotoId() != null) {
                PilotoModelo piloto = new PilotoModelo();
                piloto.setId(avionDTO.getPilotoId());
                avionExistente.setPilotoModelo(piloto);
            } else {
                // Si el pilotoId es null, desasociar el piloto existente (si hay alguno)
                avionExistente.setPilotoModelo(null);
            }

            return avionRepository.save(avionExistente);
        }

        return null;  // Manejar este caso según tus necesidades (puede ser una excepción, etc.)
    }

    public Long eliminarAvion(Long id) {
        avionRepository.deleteById(id);
        return id;
    }
}