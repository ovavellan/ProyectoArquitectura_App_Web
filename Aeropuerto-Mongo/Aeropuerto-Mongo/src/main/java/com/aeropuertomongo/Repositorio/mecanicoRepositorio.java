package com.aeropuertomongo.Repositorio;

import com.aeropuertomongo.Modelo.mecanicoModelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mecanicoRepositorio extends MongoRepository<mecanicoModelo, String> {
}
