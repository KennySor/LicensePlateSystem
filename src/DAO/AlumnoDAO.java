/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Modelo.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlumnoDAO {
    
  public boolean registrarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumnos (nombres, apellidos, dni, edad, celular, estado) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pst = null;
        
        try {
            conn = Conexion.getConnection();
            if (conn == null) return false;
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, alumno.getNombres());
            pst.setString(2, alumno.getApellidos());
            pst.setString(3, alumno.getDni());
            pst.setInt(4, alumno.getEdad());
            pst.setString(5, alumno.getCelular());
            pst.setInt(6, 0); // Estado pendiente
            
            int resultado = pst.executeUpdate();
            return resultado > 0;
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // Duplicate entry
                JOptionPane.showMessageDialog(null, "El DNI ya está registrado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar alumno: " + e.getMessage());
            }
            return false;
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
    
    public boolean existeDNI(String dni) {
        String sql = "SELECT COUNT(*) FROM alumnos WHERE dni = ?";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            if (conn == null) return false;
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, dni);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            return false;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar DNI: " + e.getMessage());
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
    
    public Alumno buscarPorDNI(String dni) {
        String sql = "SELECT * FROM alumnos WHERE dni = ?";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            if (conn == null) return null;
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, dni);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setCodigo(rs.getInt("codigo"));
                alumno.setNombres(rs.getString("nombres"));
                alumno.setApellidos(rs.getString("apellidos"));
                alumno.setDni(rs.getString("dni"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setCelular(rs.getString("celular"));
                alumno.setEstado(rs.getInt("estado"));
                alumno.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                return alumno;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumno: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        
        return null;
    }
    
    public List<Alumno> listarAlumnosPendientes() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM v_alumnos_pendientes ORDER BY apellidos, nombres";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            if (conn == null) return alumnos;
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setCodigo(rs.getInt("codigo"));
                alumno.setNombres(rs.getString("nombres"));
                alumno.setApellidos(rs.getString("apellidos"));
                alumno.setDni(rs.getString("dni"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setCelular(rs.getString("celular"));
                alumno.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                alumno.setEstado(0); // Pendiente
                alumnos.add(alumno);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar alumnos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        
        return alumnos;
    }
}
