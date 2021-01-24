package com.guillermo.cine.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guillermo.cine.fichaDescriptiva.view.FichaDescriptiva;
import com.guillermo.cine.R;
import com.guillermo.cine.beans.Pelicula;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CineAdapter extends RecyclerView.Adapter<CineAdapter.PeliculaViewHolder> {
    private final ArrayList<Pelicula> listaJuegos;
    private final Context context;

    public CineAdapter(ArrayList<Pelicula> juegos, Context context) {
        this.listaJuegos = juegos;
        this.context = context;
    }

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_pelicula, parent, false);

        return new PeliculaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        Pelicula pelicula = listaJuegos.get(position);
        holder.nombre.setText(pelicula.getNombre());
        holder.precio.setText("Precio: "+pelicula.getPrecio()+"€");
        holder.sesiones.setText(pelicula.horariosToString());
        Picasso.get().load(pelicula.getImagen()).into(holder.imagen);
        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FichaDescriptiva.class);
                intent.putExtra("pelicula_id", pelicula.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaJuegos.size();
    }

    public static class PeliculaViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;
        public TextView precio;
        public TextView sesiones;

        public PeliculaViewHolder(View v) {
            super(v);
            imagen = v.findViewById(R.id.imagenPelicula);
            nombre = v.findViewById(R.id.txtNombre);
            precio = v.findViewById(R.id.txtPrecio);
            sesiones = v.findViewById(R.id.txtSesiones);

        }
    }
}
