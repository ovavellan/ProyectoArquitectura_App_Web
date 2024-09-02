package com.proyect.aeropuerto.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AvionModelo")
public class AvionModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre_aeronave;
	private String company;
	private int capacidad_pasajeros;
	private int horas_vuelo;

	@ManyToOne()
	@JoinColumn(name = "piloto_id", nullable = false, referencedColumnName = "id")
	@JsonBackReference
	private PilotoModelo pilotoModelo;

	@Override
	public String toString() {
		// Excluir la propiedad que se refiere al PilotoModelo para evitar recursión infinita
		return "AvionModelo{" +
				"id=" + id +
				", nombre_aeronave='" + nombre_aeronave + '\'' +
				", company='" + company + '\'' +
				", capacidad_pasajeros=" + capacidad_pasajeros +
				", horas_vuelo=" + horas_vuelo +
				", piloto_id=" + pilotoModelo.getId() +
				'}';
	}
}