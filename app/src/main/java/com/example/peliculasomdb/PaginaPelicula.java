package com.example.peliculasomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PaginaPelicula extends AppCompatActivity {

    private final String URL_BASE = "http://10.0.2.2:8080/ProyectoNetflix/";
    private PeliculasAPI peliculasApi;

    private String api, prueba ;
    private TextView tpeli, apeli,dpeli, ptxt;
    private ImageView imagpeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_pelicula);
        Toolbar myToolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
        Bundle bundle = getIntent().getExtras();


        tpeli = (TextView) findViewById(R.id.tp);
        apeli = (TextView) findViewById(R.id.ap);
        dpeli = (TextView) findViewById(R.id.dpl);
        ptxt = (TextView) findViewById(R.id.punt);
        imagpeli = (ImageView) findViewById(R.id.posterp);

        tpeli.setText(bundle.getString("pelititulo"));
        apeli.setText(bundle.getString("pelianio"));
        dpeli.setText(bundle.getString("director"));
        Picasso.get().load(bundle.getString("peliposter")).into(imagpeli);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        peliculasApi = retrofit.create(PeliculasAPI.class);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;
    }
    public void guardarPelicula(View v){
        SharedPreferences preferencias=getSharedPreferences("variables", Context.MODE_PRIVATE);
        api = preferencias.getString("keyshared","");
        SharedPreferences.Editor editor=preferencias.edit();
        editor.commit();
        Call<Pelicula> call = peliculasApi.guardarPelicula(api, "s", dpeli.getText().toString());
                call.enqueue(new Callback<Pelicula>(){
                    @Override
                    public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
                        if (response.isSuccessful()){
                            funciono();
                        }else{ }
                    }
                    @Override
                    public void onFailure(Call<Pelicula> call, Throwable t) {
                        Log.e("fallo",t.getMessage());
                    }
                });

    }
    public void guardarPeliculaPuntuacion(View v){
        SharedPreferences preferencias=getSharedPreferences("variables", Context.MODE_PRIVATE);
        api = preferencias.getString("keyshared","");
        SharedPreferences.Editor editor=preferencias.edit();
        editor.commit();
        Call<Pelicula> call = peliculasApi.guardarPeliculaPuntuacion(api, "s", dpeli.getText().toString(),ptxt.getText().toString());
                call.enqueue(new Callback<Pelicula>(){
                    @Override
                    public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
                        if (response.isSuccessful()){
                            funciono();
                        }else{ }
                    }
                    @Override
                    public void onFailure(Call<Pelicula> call, Throwable t) {
                        Log.e("fallo",t.getMessage());
                    }
                });
    }
    public void funciono() {
        Toast.makeText(this, "Se ha guardado correctamente",
                Toast.LENGTH_SHORT).show();
    }}
