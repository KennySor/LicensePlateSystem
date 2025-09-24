/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Modelo.Matricula;
import java.sql.*;
import javax.swing.JOptionPane;

public class MatriculaDAO {
   
     public boolean matricularAlumno(int codigoAlumno, String codigoCurso) {
        String sql = "CALL sp_matricular_alumno(?, ?)";
        Connection conn = null;
        CallableStatement cst = null;
        
        try {
            conn = Conexion.getConnection();
            if (conn == null) return false;
            
            cst = conn.prepareCall(sql);
            cst.setInt(1, codigoAlumno);
            cst.setString(2, codigoCurso);
            
            cst.execute();
            return true;
            
        } catch (SQLException e) {
            String mensaje = e.getMessage();
            if (mensaje.contains("ya esta matriculado")) {
                JOptionPane.showMessageDialog(null, "El alumno ya está matriculado en este curso");
            } else if (mensaje.contains("curso no existe")) {
                JOptionPane.showMessageDialog(null, "El curso no existe");
            } else if (mensaje.contains("alumno esta registrado")) {
                JOptionPane.showMessageDialog(null, "El alumno ya está registrado en el sistema");
            } else {
                JOptionPane.showMessageDialog(null, "Error al matricular: " + mensaje);
            }
            return false;
        } finally {
            try {
                if (cst != null) cst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
    
    public boolean yaEstaMatriculado(int codigoAlumno, String codigoCurso) {
        String sql = "SELECT COUNT(*) FROM matriculas WHERE codigo_alumno = ? AND codigo_curso = ? AND activa = TRUE";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            if (conn == null) return false;
            
            pst = conn.prepareStatement(sql);
            pst.setInt(1, codigoAlumno);
            pst.setString(2, codigoCurso);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            return false;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar matrícula: " + e.getMessage());
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}
