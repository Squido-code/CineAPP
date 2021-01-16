package com.guillermo.cine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.guillermo.cine.listaPeliculas.view.ViewListaPeliculas;
import com.guillermo.cine.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        // Cargar la 2ª pantalla
                        Intent navegar = new Intent(
                                getBaseContext(), ViewListaPeliculas.class);
                        startActivity(navegar);
                    }
                }
                , 4000
        );
    }
}