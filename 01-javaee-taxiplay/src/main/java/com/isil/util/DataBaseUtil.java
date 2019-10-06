package com.isil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {

    private static final String URL = "jdbc:mysql://localhost:33065/taxiplay";

    private static final String USER = "root";
    private static final String PASSWORD = "toor";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
