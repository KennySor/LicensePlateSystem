
package Modelo;

public class Profesor {
    String id;
    String nombre;
    String apellido;
    String cursos;
    int añosExp;
    String especialidad;
    String codigo;

    public Profesor() {
    }

    public Profesor(String id, String nombre, String apellido, String cursos, int añosExp, String especialidad, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cursos = cursos;
        this.añosExp = añosExp;
        this.especialidad = especialidad;
        this.codigo = codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCursos() {
        return cursos;
    }

    public void setCursos(String cursos) {
        this.cursos = cursos;
    }

    public int getAñosExp() {
        return añosExp;
    }

    public void setAñosExp(int añosExp) {
        this.añosExp = añosExp;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
