package com.proyectoprueba.jesus.proyectoprueba;

public class Servicios {
    private int imagen;
    private String nombre;
    private double calificacion;
    private String direccion;



    public Servicios(int imagen, String nombre, double calificacion, String direccion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
