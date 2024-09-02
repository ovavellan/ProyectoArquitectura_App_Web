package com.aeropuertomongo.Modelo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "vuelos")
public class vueloModelo {
    @Id
    private String id;
    private Date fecha_salida;
    private int id_avion;
    private String partida;
    private String destino;
    private double precio;
    private String tipo_vuelo;
}
