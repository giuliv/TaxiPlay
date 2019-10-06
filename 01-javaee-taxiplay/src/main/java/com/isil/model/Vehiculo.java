package com.isil.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehiculo {

    private Integer id_vehiculo;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private Integer capacidad;
    private Integer id_chofer;

}
