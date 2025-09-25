/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Conexion.Conexion;
import java.sql.*;

public class AdminDAO {

    public boolean loginAdmin(String usuario, String password) {
        try {
            Connection conn = Conexion.getConnection();
            CallableStatement cs = conn.prepareCall("{call sp_login_admin(?,?)}");
            cs.setString(1, usuario);
            cs.setString(2, password);

            ResultSet rs = cs.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            System.out.println("Error en login: " + ex.getMessage());
        }
        return false;
    }
}
