package com.aeropuertomongo.Repositorio;

import com.aeropuertomongo.Modelo.mecanicoModelo;
import com.aeropuertomongo.Modelo.vueloModelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface vueloRepositorio extends MongoRepository<vueloModelo, String> {
    @Query("{'id_avion': ?0}")
    void deleteByAvionId(String id_avion);
}
