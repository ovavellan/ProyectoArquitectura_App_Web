package com.aeropuertomongo.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "mantenimiento")
public class mantenimientoModelo {
    @Id
    private String id;
    private String avion;
    private String tipo;
    private String descripcion;
    private boolean completado;
    private int avion_id; //CONSUMIR DE POSTGREST POR RESTEMPLATE O FESCH
    private List<mecanicoModelo> mecanicoModelo;
}
