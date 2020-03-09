package com.example.peliculasomdb;

public class Pelicula {
    private String usuario;
    private String pelicula;
    private int puntuacion;

    public Pelicula() {}

    public Pelicula(String usuario, String pelicula, int puntuacion) {
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.puntuacion = puntuacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
