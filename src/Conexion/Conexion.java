package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/AUN NO TENEMOS";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        try (Connection con = getConexion()) {
            if (con != null) {
                System.out.println("Conexión exitosa a la base de datos!");
            } else {
                System.out.println("No se pudo establecer la conexion.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar o cerrar: " + e.getMessage());
        }
        System.out.println("GOZU");
        String mundo = "hola";
        mundo = "mundo";
        System.out.println("aaa");
        System.out.println("asd");
    }
}
