package com.proyect.aeropuerto.DTO;

import com.proyect.aeropuerto.models.AvionModelo;
import com.proyect.aeropuerto.models.PilotoModelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvionPilotoDTO {
    private AvionModelo avion;
    private PilotoModelo piloto;
}
