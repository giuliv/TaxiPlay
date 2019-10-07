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

    public Pasajero(String nombres, String apellidos, String telefono, String correo, String clave){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "id_pasajero=" + id_pasajero +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }

}
