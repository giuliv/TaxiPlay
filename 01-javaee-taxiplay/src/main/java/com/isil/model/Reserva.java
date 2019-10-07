package com.isil.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reserva {
    private IdReserva id_reserva;
    private String direccion_partida;
    private String direccion_destino;
    private Date fecha_inicio_viaje;
    private Date fecha_fin_viaje;
    private Double latitud_inicial;
    private Double latitud_final;
    private Double longitud_inicial;
    private Double longitud_final;
    private Double distancia;
    private Double total_pagar;
    private String metodo_pago;


    public Reserva(Integer id_pasajero, Integer id_vehiculo) {

        this.id_reserva = new IdReserva(id_pasajero,id_vehiculo);

    }

    public class IdReserva{
        private Integer id_pasajero;
        private Integer id_vehiculo;

        public IdReserva(Integer id_pasajero, Integer id_vehiculo){
            this.setId_pasajero(id_pasajero);
            this.setId_vehiculo(id_vehiculo);
        }

        public Integer getId_pasajero() {
            return id_pasajero;
        }

        public void setId_pasajero(Integer id_pasajero) {
            this.id_pasajero = id_pasajero;
        }

        public Integer getId_vehiculo() {
            return id_vehiculo;
        }

        public void setId_vehiculo(Integer id_vehiculo) {
            this.id_vehiculo = id_vehiculo;
        }
    }

    @Override
    public String toString() {
        return
                "id_reserva=" + id_reserva +
                ", direccion_partida='" + direccion_partida + '\'' +
                ", direccion_destino='" + direccion_destino + '\'' +
                ", distancia=" + distancia +
                ", total_pagar=" + total_pagar +
                ", metodo_pago='" + metodo_pago + '\'' ;
    }
}
