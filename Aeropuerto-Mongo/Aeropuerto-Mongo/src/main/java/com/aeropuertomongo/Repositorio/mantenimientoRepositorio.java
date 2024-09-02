package com.aeropuertomongo.Repositorio;

import com.aeropuertomongo.Modelo.mantenimientoModelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface mantenimientoRepositorio extends MongoRepository<mantenimientoModelo, String> {


}