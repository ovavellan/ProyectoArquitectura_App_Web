package com.proyect.aeropuerto.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HangarModelo")
public class HangarModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int capacidad_aeronaves;
    private String tipo_aeronaves;

    @ManyToOne()
    @JoinColumn(name = "aeropuerto_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private AeropuertoModelo aeropuertoModelo;

    @ManyToOne()
    @JoinColumn(name = "avion_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private AvionModelo avionModelo;
}
