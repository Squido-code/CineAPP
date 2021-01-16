package com.guillermo.cine.fichaDescriptiva.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.guillermo.cine.fichaDescriptiva.contract.ContratoFichaDescriptiva;
import com.guillermo.cine.fichaDescriptiva.presenter.PresenterFichaDescriptiva;
import com.guillermo.cine.R;
import com.guillermo.cine.beans.Ficha;
import com.squareup.picasso.Picasso;

public class FichaDescriptiva extends AppCompatActivity implements ContratoFichaDescriptiva.View {
    private String peliculaId;
    private PresenterFichaDescriptiva presenterFichaDescriptiva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_descriptiva);
        getIncomingIntent();
        presenterFichaDescriptiva = new PresenterFichaDescriptiva(this);
        presenterFichaDescriptiva.getFicha(peliculaId);

    }

    private void getIncomingIntent() {
        Boolean isComplete = getIntent().hasExtra("pelicula_id");
        if (isComplete) {
            String idPelicula = getIntent().getStringExtra("pelicula_id");
            this.peliculaId = idPelicula;
        }
    }

    private void setFicha(String urlImagen, String nombre, String descripcion) {
        TextView tvNombreFicha = findViewById(R.id.txtNombreFicha);
        tvNombreFicha.setText(nombre);
        TextView tvDescripcionFicha = findViewById(R.id.txtdescription);
        tvDescripcionFicha.setText(descripcion);

        ImageView ivFicha = findViewById(R.id.imagenVideoJuegoFicha);
        Picasso.get().load(urlImagen).into(ivFicha);
    }

    @Override
    public void success(Ficha ficha) {
        String nombre = ficha.getNombre();
        String descripcion = ficha.getDescription();
        String urlImagen = ficha.getUrlImagen();
        setFicha(urlImagen, nombre, descripcion);
    }

    @Override
    public void error(String mensage) {
        Toast.makeText(this, "error al mostrar los datos", Toast.LENGTH_SHORT).show();
    }

    public String getPeliculaId() {
        return peliculaId;
    }
}