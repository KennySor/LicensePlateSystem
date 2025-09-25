/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import Conexion.Conexion;

public class ProfesorDAO {
    
    public boolean loginAdmin (String correo, String password) {
        try {
            Connection conn = Conexion.getConnection();
            CallableStatement cs = conn.prepareCall("{call sp_login_profesor(?,?)}");
            cs.setString(1, correo);
            cs.setString(2, password);

            ResultSet rs = cs.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            System.out.println("Error en login: " + ex.getMessage());
        }
        return false;
    }
    
}
