package com.example.peliculasomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Buscador extends AppCompatActivity {

    private PeliculaAdapter mAdapter;
    private RecyclerView recyclerViewPelicula;
    private final String URL_BASE = "http://10.0.2.2:8080/ProyectoNetflix/";
    private PeliculasAPI peliculasApi;
    private Button search;
    private EditText titulo;
    private String api;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);
        Toolbar myToolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
        search = (Button)findViewById(R.id.buscar);
        titulo = (EditText) findViewById(R.id.titp);
        context = this;

        Bundle bundle = getIntent().getExtras();
        api = bundle.getString("key");
        recyclerViewPelicula= findViewById(R.id.recycler);
        recyclerViewPelicula.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPelicula.setHasFixedSize(true);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.puntuaciones:
                puntuadas();
                return true;
            case R.id.milista:
                guardadas();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void buscarPelis(View v){
        Call<List<PeliculaJson>> call = peliculasApi.buscarPelicula(api, "b",titulo.getText().toString());
                call.enqueue(new Callback<List<PeliculaJson>>(){
                    @Override
                    public void onResponse(Call<List<PeliculaJson>> call, Response<List<PeliculaJson>> response) {
                        if (response.isSuccessful()){
                            mAdapter = new PeliculaAdapter(context, response.body(), this);
                            recyclerViewPelicula.setAdapter(mAdapter);

                        }else{
                            Log.e("putaaaaa", response.body().toString());
                        }
                    }
                    @Override
                    public void onFailure(Call<List<PeliculaJson>> call, Throwable t) {
                        Log.e("fallo",t.getMessage());

                    }
                });
    }

    private void puntuadas(){
        Call<List<PeliculaJson>> call = peliculasApi.getPeliculas(api, "l");
        call.enqueue(new Callback<List<PeliculaJson>>(){
            @Override
            public void onResponse(Call<List<PeliculaJson>> call, Response<List<PeliculaJson>> response) {
                if (response.isSuccessful()){
                    mAdapter = new PeliculaAdapter(context, response.body(), this);
                    recyclerViewPelicula.setAdapter(mAdapter);
                }else{ }
            }
            @Override
            public void onFailure(Call<List<PeliculaJson>> call, Throwable t) {
                Log.e("fallo",t.getMessage());
            }
        });
    }
    private void guardadas(){
        Call<List<PeliculaJson>> call = peliculasApi.getPeliculas(api, "g");
        call.enqueue(new Callback<List<PeliculaJson>>(){
            @Override
            public void onResponse(Call<List<PeliculaJson>> call, Response<List<PeliculaJson>> response) {
                if (response.isSuccessful()){
                    mAdapter = new PeliculaAdapter(context, response.body(), this);
                    recyclerViewPelicula.setAdapter(mAdapter);
                }else{ }
            }
            @Override
            public void onFailure(Call<List<PeliculaJson>> call, Throwable t) {
                Log.e("fallo",t.getMessage());
            }
        });
    }
}
