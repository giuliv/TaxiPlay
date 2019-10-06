package com.isil.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pasajero {

    private  Integer id_pasajero;
    private String nombres;
    private String apellidos;
    private  String telefono;
    private String correo;
    private String clave;

}
