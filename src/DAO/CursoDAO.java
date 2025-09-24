/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Modelo.Curso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CursoDAO {
     public List<Curso> listarCursos() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM cursos ORDER BY ciclo, asignatura";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            if (conn == null) return cursos;
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setCodigo(rs.getString("codigo"));
                curso.setAsignatura(rs.getString("asignatura"));
                curso.setCiclo(rs.getInt("ciclo"));
                curso.setCreditos(rs.getInt("creditos"));
                curso.setHoras(rs.getInt("horas"));
                curso.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                cursos.add(curso);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar cursos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        
        return cursos;
    }
    
    public Curso buscarPorCodigo(String codigo) {
        String sql = "SELECT * FROM cursos WHERE codigo = ?";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            if (conn == null) return null;
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, codigo);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                Curso curso = new Curso();
                curso.setCodigo(rs.getString("codigo"));
                curso.setAsignatura(rs.getString("asignatura"));
                curso.setCiclo(rs.getInt("ciclo"));
                curso.setCreditos(rs.getInt("creditos"));
                curso.setHoras(rs.getInt("horas"));
                curso.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                return curso;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar curso: " + e.getMessage());
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
}
