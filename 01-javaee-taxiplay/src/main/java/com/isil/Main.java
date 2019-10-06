package com.isil;

import com.isil.dao.ChoferDAO;
import com.isil.model.Chofer;
import com.isil.mysql.MySQLChoferDAO;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        MySQLChoferDAO choferDAO = new MySQLChoferDAO();
        List<Chofer> choferes = choferDAO.obtenerTodos();
        //Chofer ch = new Chofer("Joaquín","Perez","29837644","945673456","joaquin@gmail.com");


         /*prueba insertar registro
        Chofer ch = new Chofer("Joaquín","Perez","29837644","945673456","joaquin@gmail.com");
        choferDAO.insertar(ch);*/

        /*prueba listar uno
        System.out.println(choferDAO.obtenerUno(1));*/

        /*prueba listar todos
        choferes.stream().forEach(u -> System.out.println("user = " + u));*/




    }
}
