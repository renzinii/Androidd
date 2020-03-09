package com.example.peliculasomdb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeliculasAPI {
    @GET("interfaz")
    Call<Usuario> guardarUsuario(@Query("key") String key);
    @GET("interfaz")
    Call<List<PeliculaJson>> getPeliculas(@Query("key") String key, @Query("a") String a);
    @GET("interfaz")
    Call<Pelicula> guardarPelicula(@Query("key") String key, @Query("a") String act, @Query("id") String id);
    @GET("interfaz")
    Call<List<PeliculaJson>> buscarPelicula(@Query("key") String key, @Query("a") String act, @Query("t") String titulo);
    @GET("interfaz")
    Call<Pelicula> guardarPeliculaPuntuacion(@Query("key") String key, @Query("a") String action, @Query("id") String idp,
                                             @Query("p") String p);

}
