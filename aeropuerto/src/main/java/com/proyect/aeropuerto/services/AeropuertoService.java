package com.proyect.aeropuerto.services;

import com.proyect.aeropuerto.models.AeropuertoModelo;
import com.proyect.aeropuerto.models.PilotoModelo;
import com.proyect.aeropuerto.repositories.AeropuertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeropuertoService {
    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    public List<AeropuertoModelo> getAll() {
        return aeropuertoRepository.findAll();
    }

    public boolean save(AeropuertoModelo aeropuertoModelo) {
        aeropuertoRepository.save(aeropuertoModelo);
        return true;
    }

    public boolean update(Long aeropuertoId, AeropuertoModelo aeropuertoModelo) {
        if (aeropuertoRepository.existsById(aeropuertoId)) {
            aeropuertoModelo.setId(aeropuertoId);
            aeropuertoRepository.save(aeropuertoModelo);
            return true;
        }
        return false;
    }

    public AeropuertoModelo getById(Long aeropuertoId) {
        return aeropuertoRepository.findById(aeropuertoId).orElse(null);
    }

    public boolean delete(Long aeropuertoId) {
        if (aeropuertoRepository.existsById(aeropuertoId)) {
            aeropuertoRepository.deleteById(aeropuertoId);
            return true;
        }
        return false;
    }

}
