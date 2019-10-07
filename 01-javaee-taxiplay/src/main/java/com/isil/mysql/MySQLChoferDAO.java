package com.isil.mysql;

import com.isil.dao.ChoferDAO;
import com.isil.model.Chofer;
import com.isil.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLChoferDAO implements ChoferDAO {
    final String INSERT = "insert into chofer(nombres, apellidos, dni, telefono, correo) values (?,?,?,?,?)";
    final String UPDATE = "update chofer set nombres=?, apellidos=?, dni=?, telefono=?, correo=? where id_chofer=?";
    final String DELETE = "delete from chofer where id_chofer=?";
    final String GETALL = "select id_chofer, nombres, apellidos, dni, telefono, correo from chofer";
    final String GETONE = "select id_chofer, nombres, apellidos, dni, telefono, correo from chofer where id_chofer=?";

    @Override
    public void insertar(Chofer a) {
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, a.getNombres());
                statement.setString(2, a.getApellidos());
                statement.setString(3, a.getDni());
                statement.setString(4, a.getTelefono());
                statement.setString(5, a.getCorreo());
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
    public void modificar(Chofer a, Integer id) {
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
                statement.setString(1, a.getNombres());
                statement.setString(2, a.getApellidos());
                statement.setString(3, a.getDni());
                statement.setString(4, a.getTelefono());
                statement.setString(5, a.getCorreo());
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
    public List<Chofer> obtenerTodos() {
        List<Chofer> choferes = new ArrayList<>();
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(GETALL)) {
                    while (resultSet.next()) {
                        choferes.add(recorreChofer(resultSet));
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return choferes;
    }

    @Override
    public Chofer obtenerUno(Integer id) {
        Chofer chofer = null;
        try (Connection connection = DataBaseUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(GETONE)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        chofer = recorreChofer(resultSet);
                        System.out.println("Estos son los datos del Chofer: ");
                        System.out.println(chofer.toString());
                    }else{
                        System.out.println("El Id que ingresó no se encuentra en el registro");
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        return chofer;
    }
    public Chofer recorreChofer(ResultSet rs) throws SQLException {
        String nombres = rs.getString("nombres");
        String apellidos = rs.getString("apellidos");
        String dni = rs.getString("dni");
        String telefono = rs.getString("telefono");
        String correo = rs.getString("correo");
        Integer id_chofer = rs.getInt("id_chofer");
        Chofer chofer = new Chofer(id_chofer, nombres, apellidos, dni, telefono, correo);
        return chofer;
    }

}
