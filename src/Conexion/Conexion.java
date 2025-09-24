package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_matricula";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // Pon tu contraseña de MySQL aquí
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver MySQL no encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión MySQL: " + e.getMessage());
            return null;
        }
    }
}
