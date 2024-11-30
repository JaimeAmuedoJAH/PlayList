package com.jah.playlist;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//MainActivity con un RecyclerView.
public class MainActivity extends AppCompatActivity {

    RecyclerView rvCanciones;
    LinearLayoutManager disposicionP;
    GridLayoutManager disposicionL;
    AdaptadorCanciones adaptadorCanciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rvCanciones = findViewById(R.id.rvCanciones);
        initDisposicion();
        GestionCanciones.cargarCanciones(getApplicationContext());
        GestionCanciones.iniciarValor();
        adaptadorCanciones = new AdaptadorCanciones(GestionCanciones.getArrCanciones());
        rvCanciones.setAdapter(adaptadorCanciones);

        if(savedInstanceState != null){
            GestionCanciones.setArrCanciones((ArrayList<Cancion>) savedInstanceState.getSerializable("canciones"));
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("canciones", new ArrayList<>(GestionCanciones.getArrCanciones()));
    }

    private void initDisposicion() {
        if((getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)){
            disposicionP = new LinearLayoutManager(getApplicationContext());
            rvCanciones.setLayoutManager(disposicionP);
        }else {
            disposicionL = new GridLayoutManager(getApplicationContext(), 2);
            rvCanciones.setLayoutManager(disposicionL);
        }
    }
}