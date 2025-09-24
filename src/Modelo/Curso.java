/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Timestamp;

public class Curso {

     private String codigo; // VARCHAR(4)
    private String asignatura;
    private int ciclo;
    private int creditos;
    private int horas;
    private Timestamp fechaRegistro;
    
    // Constructores
    public Curso() {}
    
    public Curso(String codigo, String asignatura, int ciclo, int creditos, int horas) {
        this.codigo = codigo;
        this.asignatura = asignatura;
        this.ciclo = ciclo;
        this.creditos = creditos;
        this.horas = horas;
    }
    
    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }
    
    public int getCiclo() { return ciclo; }
    public void setCiclo(int ciclo) { this.ciclo = ciclo; }
    
    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
    
    public int getHoras() { return horas; }
    public void setHoras(int horas) { this.horas = horas; }
    
    public Timestamp getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Timestamp fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    
    @Override
    public String toString() {
        return codigo + " - " + asignatura;
    }

   
}
