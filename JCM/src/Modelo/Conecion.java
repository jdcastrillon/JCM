/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ASUS_01
 */
public class Conecion {
    private String nombre;
    private String drive;
    private String libreria;
    private String puerto;

    public Conecion() {
    }

    public Conecion(String nombre, String drive) {
        this.nombre = nombre;
        this.drive = drive;
    }

    public Conecion(String nombre, String drive, String libreria) {
        this.nombre = nombre;
        this.drive = drive;
        this.libreria = libreria;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getLibreria() {
        return libreria;
    }

    public void setLibreria(String libreria) {
        this.libreria = libreria;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
        

    @Override
    public String toString() {
        return "Conecion{" + "nombre=" + nombre + ", drive=" + drive + '}';
    }
    
    
}
