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

    public Vehiculo(String placa, String marca, String modelo, String color, Integer capacidad, Integer id_chofer){
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.capacidad = capacidad;
        this.id_chofer = id_chofer;
    }

    @Override
    public String toString() {
        return
                "id_vehiculo=" + id_vehiculo +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", capacidad=" + capacidad +
                ", id_chofer=" + id_chofer ;

    }
}
