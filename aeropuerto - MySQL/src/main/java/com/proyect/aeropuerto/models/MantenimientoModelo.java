package com.proyect.aeropuerto.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "Mantenimiento")
public class MantenimientoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String descripcion;


    @ManyToOne
    @JoinColumn(name = "mecanico_id", nullable = false)
    private MecanicoModelo mecanico;
}
