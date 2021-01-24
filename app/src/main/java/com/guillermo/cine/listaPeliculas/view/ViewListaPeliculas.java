package com.guillermo.cine.listaPeliculas.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.guillermo.cine.listaPeliculas.contract.ContratoListaPeliculas;
import com.guillermo.cine.R;
import com.guillermo.cine.adapter.CineAdapter;
import com.guillermo.cine.beans.Pelicula;
import com.guillermo.cine.listaPeliculas.presenter.PresentadorListaPeliculas;

import java.util.ArrayList;


public class ViewListaPeliculas extends AppCompatActivity implements ContratoListaPeliculas.View {
    private PresentadorListaPeliculas presentadorListaPeliculas;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_peliculas);
        presentadorListaPeliculas = new PresentadorListaPeliculas(this);
        presentadorListaPeliculas.getPeliculas(false);
        filtrado();
    }


    @Override
    public void success(ArrayList<Pelicula> peliculas) {
        recyclerView = findViewById(R.id.recyclerPeliculas);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CineAdapter adapter = new CineAdapter(peliculas, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void error(String mensage) {
        Toast.makeText(this, "No existen peliculas", Toast.LENGTH_LONG).show();
    }


    public void filtrado() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String[] generos = new String[]{"Filtro por genero:", "todos", "acción", "aventura", "terror", "ciencia ficcion"};
        ArrayAdapter<String> adapterFiltro = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, generos);
        adapterFiltro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterFiltro);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                String selecteditem = adapter.getItemAtPosition(i).toString();
                String seleccion = selecteditem;
                switch (seleccion) {
                    case "Filtro por genero:":
                        return;
                    case "todos":
                        presentadorListaPeliculas.getPeliculas(false);
                        break;
                    default:
                        presentadorListaPeliculas.setFiltro(selecteditem);
                        presentadorListaPeliculas.getPeliculas(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                return;
            }
        });
    }

    public void filtradoPorPalabra(View view){
        EditText filtradoTexto = (EditText) findViewById(R.id.textoFiltrado);
        String texto = String.valueOf(filtradoTexto.getText());
        presentadorListaPeliculas.getPeliculasFiltro(texto);

    }
    public void limpiarFiltro(View view){
        EditText filtradoTexto = (EditText) findViewById(R.id.textoFiltrado);
        filtradoTexto.setText("Filtrar por titulo");
        presentadorListaPeliculas.getPeliculas(false);
    }
    public void ordenVotos(View view){

    }

}