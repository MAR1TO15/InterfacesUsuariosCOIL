
package models;


public class Carrera {
    private int id_carrera;
    private String nombre;

    public Carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
