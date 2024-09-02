package com.aeropuertomongo.Modelo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "mecanico")
public class mecanicoModelo {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String cedula;
    private String especialidad;

}
