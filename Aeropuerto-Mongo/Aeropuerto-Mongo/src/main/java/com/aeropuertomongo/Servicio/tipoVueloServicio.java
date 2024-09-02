package com.aeropuertomongo.Servicio;

import com.aeropuertomongo.Modelo.tipoModelo;
import com.aeropuertomongo.Repositorio.tipoVueloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tipoVueloServicio {
    @Autowired
    private tipoVueloRepositorio repositorio;

    @Autowired  // Agregado para autowired MongoTemplate
    private MongoTemplate mongoTemplate;

    public List<tipoModelo> obtenerTodosTipos() {
        return repositorio.findAll();
    }

    public tipoModelo crear(tipoModelo tipoVuelo) {
        return repositorio.save(tipoVuelo);
    }

    public tipoModelo actualizar(String id, tipoModelo tipoVuelo) {
        tipoVuelo.setId(id);
        return repositorio.save(tipoVuelo);
    }

    public String eliminar(String id) {
        repositorio.deleteById(id);
        return id;
    }

    public boolean delete(String tipoId) {
        if (repositorio.existsById(tipoId)) {
            repositorio.deleteById(tipoId);
            return true;
        }
        return false;
    }
}
