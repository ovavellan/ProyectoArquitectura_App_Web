package com.aeropuertomongo.Servicio;

import com.aeropuertomongo.Modelo.mantenimientoModelo;
import com.aeropuertomongo.Modelo.vueloModelo;
import com.aeropuertomongo.Repositorio.mantenimientoRepositorio;
import com.aeropuertomongo.Repositorio.vueloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class vueloServicio {
    @Autowired
    private vueloRepositorio repositorio;
    private final MongoTemplate mongoTemplate;

    public vueloServicio(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    public List<vueloModelo> obtenerTodosVuelos() {
        return repositorio.findAll();
    }
    public vueloModelo crear(vueloModelo vModelo) {
        return repositorio.save(vModelo);
    }
    public vueloModelo actualizar(String id, vueloModelo vModelo) {
        vModelo.setId(id);
        return repositorio.save(vModelo);
    }
    public String eliminar(String id){
        repositorio.deleteById(id);
        return id;
    }
    public Long eliminarVuelosPorAvion(String id_avion){
        Criteria criteria = Criteria.where("id_avion").is(Integer.parseInt(id_avion));
        Query query = new Query(criteria);
        long cantidadEliminada = mongoTemplate.remove(query, vueloModelo.class).getDeletedCount();
        return cantidadEliminada;
    }
}