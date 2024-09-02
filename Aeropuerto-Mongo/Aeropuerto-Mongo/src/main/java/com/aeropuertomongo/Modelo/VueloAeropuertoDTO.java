package com.aeropuertomongo.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VueloAeropuertoDTO {
    private Date fecha_salida;
    private int id_avion;
    private String partida;
    private String destino;
    private double precio;
    private String tipo_vuelo;
}
