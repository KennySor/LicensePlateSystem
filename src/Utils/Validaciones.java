/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Validaciones {
    
  public static boolean validarDNI(String dni) {
        return dni != null && dni.matches("\\d{8}") && !dni.isEmpty();
    }
    
    public static boolean validarCelular(String celular) {
        return celular != null && celular.matches("\\d{9,15}") && !celular.isEmpty();
    }
    
    public static boolean campoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
    
    public static boolean validarEdad(int edad) {
        return edad >= 16 && edad <= 80;
    }
    
    public static boolean validarEdadString(String edadStr) {
        try {
            int edad = Integer.parseInt(edadStr);
            return validarEdad(edad);
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void limpiarCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }
    
    public static void limpiarPasswordFields(JPasswordField... campos) {
        for (JPasswordField campo : campos) {
            campo.setText("");
        }
    }
    
    public static boolean validarSoloLetras(String texto) {
        return texto != null && texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") && !texto.trim().isEmpty();
    }
    
    public static boolean validarSoloNumeros(String texto) {
        return texto != null && texto.matches("\\d+") && !texto.isEmpty();
    }
    
    public static boolean validarCodigoCurso(String codigo) {
        return codigo != null && codigo.matches("\\d{4}") && !codigo.isEmpty();
    }
}
