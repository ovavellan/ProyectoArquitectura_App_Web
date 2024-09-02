package com.proyect.aeropuerto.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PilotoModelo")
public class PilotoModelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dni;
	private String name;
	private String lastname;
	private String address;
	private String birthday;
	private String fecha_emis_licencia;

	@OneToMany(mappedBy = "pilotoModelo", cascade = CascadeType.PERSIST)
	private List<AvionModelo> avionModelo;
}
