package com.aeropuertomongo.Repositorio;

import com.aeropuertomongo.Modelo.tipoModelo;
import com.aeropuertomongo.Modelo.vueloModelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tipoVueloRepositorio extends MongoRepository<tipoModelo, String> {
}
