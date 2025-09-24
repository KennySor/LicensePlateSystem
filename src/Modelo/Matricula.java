/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Timestamp;

public class Matricula {
      private int codigo;
    private int codigoAlumno;
    private String codigoCurso;
    private Timestamp fechaMatricula;
    private boolean activa;
    
    // Constructores
    public Matricula() {}
    
    public Matricula(int codigoAlumno, String codigoCurso) {
        this.codigoAlumno = codigoAlumno;
        this.codigoCurso = codigoCurso;
        this.activa = true;
    }
    
    // Getters y Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    
    public int getCodigoAlumno() { return codigoAlumno; }
    public void setCodigoAlumno(int codigoAlumno) { this.codigoAlumno = codigoAlumno; }
    
    public String getCodigoCurso() { return codigoCurso; }
    public void setCodigoCurso(String codigoCurso) { this.codigoCurso = codigoCurso; }
    
    public Timestamp getFechaMatricula() { return fechaMatricula; }
    public void setFechaMatricula(Timestamp fechaMatricula) { this.fechaMatricula = fechaMatricula; }
    
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

}
