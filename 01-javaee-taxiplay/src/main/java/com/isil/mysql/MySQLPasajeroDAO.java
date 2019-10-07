package com.isil.mysql;

import com.isil.dao.ChoferDAO;
import com.isil.dao.PasajeroDAO;
import com.isil.model.Chofer;
import com.isil.model.Pasajero;
import com.isil.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLPasajeroDAO implements PasajeroDAO {

    final String INSERT = "insert into pasajero(nombres, apellidos, telefono, correo, clave) values (?,?,?,?,?)";
    final String UPDATE = "update pasajero set nombres=?, apellidos=?, telefono=?, correo=?, clave=? where id_pasajero=?";
    final String DELETE = "delete from pasajero where id_pasajero=?";
    final String GETALL = "select id_pasajero, nombres, apellidos, telefono, correo, clave from pasajero";
    final String GETONE = "select id_pasajero, nombres, apellidos, telefono, correo, clave from pasajero where id_pasajero=?";


    @Override
    public void insertar(Pasajero a) {
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, a.getNombres());
                statement.setString(2, a.getApellidos());
                statement.setString(3, a.getTelefono());
                statement.setString(4, a.getCorreo());
                statement.setString(5, a.getClave());
                if (statement.executeUpdate() == 0){
                    System.out.println("No se pudo insertar!!!");
                }else{
                    System.out.println("Acabas de insertar un registro!!!");
                }
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()){
                    a.setId_pasajero(rs.getInt(1));
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void modificar(Pasajero a, Integer id) {
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
                statement.setString(1, a.getNombres());
                statement.setString(2, a.getApellidos());
                statement.setString(3, a.getTelefono());
                statement.setString(4, a.getCorreo());
                statement.setString(5, a.getClave());
                statement.setInt(6, id);
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
                statement.executeUpdate();
                if (statement.executeUpdate() == 0) {
                    System.out.println("No se pudo eliminar el registro porque el Id no está registrado!!!");
                }else{
                    System.out.println("Acabas de eliminar un registro!");
                }
            }

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Pasajero> obtenerTodos() {
        List<Pasajero> pasajeros = new ArrayList<>();
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(GETALL)) {
                    while (resultSet.next()) {
                        pasajeros.add(recorrePasajero(resultSet));
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return pasajeros;
    }

    @Override
    public Pasajero obtenerUno(Integer id) {
        Pasajero pasajero = null;
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(GETONE)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        pasajero = recorrePasajero(resultSet);
                        System.out.println("Estos son los datos del Pasajero: ");
                        System.out.println(pasajero.toString());
                    }else{
                        System.out.println("El Id que ingresó no se encuentra en el registro");
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        return pasajero;
    }

    public Pasajero recorrePasajero(ResultSet rs) throws SQLException {
        String nombres = rs.getString("nombres");
        String apellidos = rs.getString("apellidos");
        String telefono = rs.getString("telefono");
        String correo = rs.getString("correo");
        String clave = rs.getString("clave");
        Integer id_pasajero = rs.getInt("id_pasajero");
        Pasajero pasajero = new Pasajero(id_pasajero, nombres, apellidos, telefono, correo, clave);
        return pasajero;
    }
}
