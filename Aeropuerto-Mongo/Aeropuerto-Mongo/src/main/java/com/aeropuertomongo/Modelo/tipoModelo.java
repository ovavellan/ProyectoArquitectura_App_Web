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
@Document(collection = "tipo_vuelos")
public class tipoModelo {
    @Id
    private String id;
    private String tipo;
}
