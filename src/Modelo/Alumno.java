/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Timestamp;

public class Alumno {

   private int codigo;
    private String nombres;
    private String apellidos;
    private String dni;
    private int edad;
    private String celular;
    private int estado; // 0=pendiente, 1=matriculado, 2=retirado
    private Timestamp fechaRegistro;
    
    // Constructores
    public Alumno() {}
    
    public Alumno(String nombres, String apellidos, String dni, int edad, String celular) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.celular = celular;
        this.estado = 0; // Pendiente por defecto
    }
    
    // Getters y Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    
    public int getEstado() { return estado; }
    public void setEstado(int estado) { this.estado = estado; }
    
    public Timestamp getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Timestamp fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }
    
    public String getEstadoTexto() {
        switch(estado) {
            case 0: return "Pendiente";
            case 1: return "Matriculado";
            case 2: return "Retirado";
            default: return "Desconocido";
        }
    }
}
