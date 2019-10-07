package com.isil.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chofer {
    private Integer id_chofer;
    private String  nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private String correo;

    public Chofer(String nombres, String apellidos, String dni, String telefono, String correo){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return
                "id_chofer=" + id_chofer +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' ;

    }
}
