package com.proyect.aeropuerto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.proyect.aeropuerto.models.PilotoModelo;
import com.proyect.aeropuerto.repositories.PilotoRepository;

@Service
public class PilotoService {

	@Autowired
	private PilotoRepository pilotoRepository;

	public List<PilotoModelo> getAll() {
		return pilotoRepository.findAll();
	}

	public boolean save(PilotoModelo pilotoModelo) {
		pilotoRepository.save(pilotoModelo);
		return true;
	}

	public boolean update(Long pilotoId, PilotoModelo pilotoModelo) {
		if (pilotoRepository.existsById(pilotoId)) {
			pilotoModelo.setId(pilotoId);
			pilotoRepository.save(pilotoModelo);
			return true;
		}
		return false;
	}

	public PilotoModelo getById(Long pilotoId) {
		return pilotoRepository.findById(pilotoId).orElse(null);
	}

	public boolean delete(Long pilotoId) {
		if (pilotoRepository.existsById(pilotoId)) {
			pilotoRepository.deleteById(pilotoId);
			return true;
		}
		return false;
	}

	public PilotoModelo getByNombreAndApellido(String nombre, String apellido) {
		return pilotoRepository.findByNameAndLastname(nombre, apellido);
	}
}





