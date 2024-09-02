package com.proyect.aeropuerto.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvionDTO {
    private String nombre_aeronave;
    private String company;
    private int capacidad_pasajeros;
    private int horas_vuelo;
    private Long pilotoId;
}
