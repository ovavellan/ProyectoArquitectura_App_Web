package com.proyect.aeropuerto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.StringBufferInputStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AeropuertoModelo")
public class AeropuertoModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_aeropuerto;
    private String pais;
    private String ciudad;
    private int numero_hagares;
}
