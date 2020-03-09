package com.example.peliculasomdb;


class PeliculaSprites {

    private String poster;

    public PeliculaSprites(){ }
    public PeliculaSprites(String poster){
        this.poster=poster;
    }
    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
}
