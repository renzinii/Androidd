package com.example.peliculasomdb;

public class PeliculaJson {
    private String titulo;
    private String anio;
    private String director;
    private String plot;
    private String poster;
    private String imdbid;

    public PeliculaJson() { }
    public PeliculaJson(String titulo, String anio, String director, String plot, String poster, String imdbid) {
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.plot = plot;
        this.poster = poster;
        this.imdbid = imdbid;
    }
    public String getImdbid() {
        return imdbid;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
