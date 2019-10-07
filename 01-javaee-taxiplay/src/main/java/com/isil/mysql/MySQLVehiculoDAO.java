package com.isil.mysql;

import com.isil.dao.VehiculoDAO;
import com.isil.model.Vehiculo;
import com.isil.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLVehiculoDAO implements VehiculoDAO {
    final String INSERT = "insert into vehiculo(placa, marca, modelo, color, capacidad, id_chofer) values (?,?,?,?,?,?)";
    final String UPDATE = "update vehiculo set placa=?, marca=?, modelo=?, color=?, capacidad=? id_chofer=? where id_vehiculo=?";
    final String DELETE = "delete from vehiculo where id_vehiculo=?";
    final String GETALL = "select id_vehiculo, placa, marca, modelo, color, capacidad, id_chofer from vehiculo";
    final String GETONE = "select id_vehiculo, placa, marca, modelo, color, capacidad, id_chofer from vehiculo where id_vehiculo=?";

    @Override
    public void insertar(Vehiculo a) {
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, a.getPlaca());
                statement.setString(2, a.getMarca());
                statement.setString(3, a.getModelo());
                statement.setString(4, a.getColor());
                statement.setInt(5, a.getCapacidad());
                statement.setInt(6, a.getId_chofer());
                if (statement.executeUpdate() == 0){
                    System.out.println("No se pudo insertar!!!");
                }else{
                    System.out.println("Acabas de insertar un registro!!!");
                }
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()){
                    a.setId_chofer(rs.getInt(1));
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void modificar(Vehiculo a, Integer id) {
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
                statement.setString(1, a.getPlaca());
                statement.setString(2, a.getMarca());
                statement.setString(3, a.getModelo());
                statement.setString(4, a.getColor());
                statement.setInt(5, a.getCapacidad());
                statement.setInt(6, a.getId_chofer());
                statement.setInt(7, id);
                if (statement.executeUpdate() == 0) {
                    System.out.println("No se pudo modificar porque no existe el ID!!!");
                }else{
                    System.out.println("Acabas de actualizar los datos de este chofer");
                    System.out.println(a.toString());
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void eliminar(Integer id) {
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
                statement.setInt(1, id);
                if (statement.executeUpdate() == 0) {
                    System.out.println("No se pudo eliminar!!!");
                }else{
                    System.out.println("Acabas de eliminar un registro!");
                }
            }

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Vehiculo> obtenerTodos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(GETALL)) {
                    while (resultSet.next()) {
                        vehiculos.add(recorreVehiculo(resultSet));
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return vehiculos;
    }

    @Override
    public Vehiculo obtenerUno(Integer id) {
        Vehiculo vehiculo = null;
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(GETONE)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        vehiculo = recorreVehiculo(resultSet);
                        System.out.println("Estos son los datos del Chofer: ");
                        System.out.println(vehiculo.toString());
                    }else{
                        System.out.println("El Id que ingresó no se encuentra en el registro");
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        return vehiculo;
    }

    public Vehiculo recorreVehiculo(ResultSet rs) throws SQLException {
        String placa = rs.getString("placa");
        String marca = rs.getString("marca");
        String modelo = rs.getString("modelo");
        String color = rs.getString("color");
        Integer capacidad = rs.getInt("capacidad");
        Integer id_chofer = rs.getInt("id_chofer");
        Integer id_vehiculo = rs.getInt("id_vehiculo");
        Vehiculo vehiculo = new Vehiculo(id_vehiculo, placa, marca, modelo, color, capacidad, id_chofer);
        return vehiculo;
    }
}
