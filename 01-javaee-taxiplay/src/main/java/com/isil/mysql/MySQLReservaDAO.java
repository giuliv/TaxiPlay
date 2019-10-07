package com.isil.mysql;

import com.isil.dao.ReservaDAO;
import com.isil.model.Reserva;



import java.sql.*;
import java.util.List;

public class MySQLReservaDAO implements ReservaDAO {

    final String INSERT = "insert into reserva(id_pasajero, id_vehiculo, direccion_partida, direccion_destino, fecha_inicio_viaje, fecha_fin_viaje, latitud_inicial, latitud_final," +
            "longitud_inicial,longitud_final,distancia,total_pagar,metodo_pago) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE = "update reserva set direccion_partida=?, direccion_destino=?,metodo_pago=? where id_reserva=?";
    final String DELETE = "delete from reserva where id_reserva=?";
    final String GETALL = "select * from reserva";
    final String GETONE = "select * from reserva where id_reserva=?";


    @Override
    public void insertar(Reserva a) {
       /* try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
                statement.setInt(1, a.getId_reserva().getId_pasajero());
                statement.setInt(2, a.getId_reserva().getId_vehiculo());
                statement.setString(3, a.getDireccion_partida());
                statement.setString(4, a.getDireccion_destino());
                statement.setDate(5, new Date(a.getFecha_inicio_viaje().getTime()));
                statement.setDate(6, new Date(a.getFecha_fin_viaje().getTime()));
                statement.setDouble(7,a.getLatitud_inicial());
                statement.setDouble(8,a.getLatitud_final());
                statement.setDouble(9,a.getLongitud_inicial());
                statement.setDouble(10,a.getLongitud_final());
                statement.setDouble(11,a.getDistancia());
                statement.setDouble(12,a.getTotal_pagar());

                if (statement.executeUpdate() == 0){
                    System.out.println("No se pudo insertar!!!");
                }else{
                    System.out.println("Acabas de insertar un registro!!!");
                }

            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }*/
    }

    @Override
    public void modificar(Reserva a, Reserva.IdReserva id) {

    }

    @Override
    public void eliminar(Reserva.IdReserva id) {

    }

    @Override
    public List<Reserva> obtenerTodos() {
               /* List<Reserva> reservas = new ArrayList<>();
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(GETALL)) {
                    while (resultSet.next()) {
                        reservas.add(recorreReserva(resultSet));
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }*/
        return null;
    }

    @Override
    public Reserva obtenerUno(Reserva.IdReserva id) {
        /*Reserva reserva = null;
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(GETONE)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        reserva = recorreReserva(resultSet);
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }*/return  null;
    }
    public Reserva recorreReserva(ResultSet rs) throws SQLException {

       /* Integer id_reserva = rs.getInt("id_reserva");
        Integer id_pasajero = rs.getInt("id_pasajero");
        Integer id_vehiculo = rs.getInt("id_vehiculo");
        String direccion_partida = rs.getString("direccion_partida");
        String direccion_destino = rs.getString("direccion_destino");
        Date fecha_inicio_viaje = rs.getDate("fecha_inicio_viaje");
        Date fecha_fin_viaje = rs.getDate("fecha_fin_viaje");
        Double latitud_inicial = rs.getDouble("latitud_inicial");
        Double latitud_final = rs.getDouble("latitud_final");
        Double longitud_inicial = rs.getDouble("longitud_inicial");
        Double longitud_final = rs.getDouble("longitud_final");
        Double distancia = rs.getDouble("distancia");
        Double total_pagar = rs.getDouble("total_pagar");
        String metodo_pago = rs.getString("metodo_pago");


        Reserva reserva = new Reserva(id_reserva, id_pasajero, id_vehiculo, direccion_partida, direccion_destino, fecha_inicio_viaje, fecha_fin_viaje,
        latitud_inicial,latitud_final,longitud_inicial, longitud_final, distancia,total_pagar,metodo_pago);*/
        return null;
    }

}
