package com.isil;

import com.isil.model.Chofer;

import com.isil.mysql.MySQLChoferDAO;
import com.isil.mysql.MySQLReservaDAO;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //eliminar();
        //insertar("Alejandro","Figeroa","28884444","945672222","alejo@gmail.com");
        //listarTodos();
        //listarUno();
        //modificar("Alejandro","Figeroa","22222222","777777777","alejofigeroa@gmail.com");

    }
    static MySQLChoferDAO choferDAO = new MySQLChoferDAO();
    static List<Chofer> choferes = choferDAO.obtenerTodos();
    static  Chofer chofer = new Chofer();
    static MySQLReservaDAO reservaDAO = new MySQLReservaDAO();
    static Scanner sc = new Scanner(System.in);

    public static void eliminar(){
        System.out.println("Ingrese el ID del registro a eliminar: \n");
        Integer st = sc.nextInt();
        choferDAO.eliminar(st);
    }

    public static void insertar(String nombre, String apellidos, String dni, String telefono, String correo){
        Chofer chofer = new Chofer(nombre,apellidos,dni,telefono,correo);
        choferDAO.insertar(chofer);
        System.out.println("Datos del chofer:  "+chofer.toString());
    }

    public static void listarTodos(){
        System.out.println("**  Estos son todos los choferes registrados  **");
        choferes.stream().forEach(u -> System.out.println("Datos de Chofer : "+u));
    }

    public static void listarUno(){
        System.out.println("Ingrese el ID del chofer que busca: \n");
        Integer st = sc.nextInt();
        choferDAO.obtenerUno(st);
    }

    public static void modificar(String nombre, String apellidos, String dni, String telefono, String correo) {
        Chofer chofer = new Chofer(nombre, apellidos, dni, telefono, correo);
        System.out.println("Ingrese el ID del chofer para actualizar sus datos: \n");
        Integer st = sc.nextInt();
        choferDAO.modificar(chofer, st);
    }
}
