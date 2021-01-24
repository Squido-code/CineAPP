package com.guillermo.cine.listaPeliculas.presenter;

import android.widget.Switch;

import com.guillermo.cine.beans.Pelicula;
import com.guillermo.cine.listaPeliculas.contract.ContratoListaPeliculas;
import com.guillermo.cine.listaPeliculas.model.ModelListaPeliculas;
import com.guillermo.cine.listaPeliculas.view.ViewListaPeliculas;

import java.util.ArrayList;
import java.util.HashMap;

public class PresentadorListaPeliculas implements ContratoListaPeliculas.Presenter {
    private final ViewListaPeliculas listaVideojuegos;
    private final ModelListaPeliculas modelListaPeliculas;
    private String filtro;

    public PresentadorListaPeliculas(ViewListaPeliculas listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
        modelListaPeliculas = new ModelListaPeliculas();
    }

    @Override
    public void getPeliculas() {

        modelListaPeliculas.getPeliculasWS(new ContratoListaPeliculas.Model.OnLstPeliculasListener() {
            @Override
            public void onResolve(ArrayList<Pelicula> peliculas) {
                listaVideojuegos.success(peliculas);
            }

            @Override
            public void onReject(String error) {
                listaVideojuegos.error("Error al tratar los datos");
            }
        });

    }
    @Override
    public void getPeliculasFiltroTexto(String filtro){
        modelListaPeliculas.getPeliculasTextoWS(new ContratoListaPeliculas.Model.OnLstPeliculasListener() {
            @Override
            public void onResolve(ArrayList<Pelicula> peliculas) {
                listaVideojuegos.success(peliculas);
            }

            @Override
            public void onReject(String error) {
                listaVideojuegos.error("Error al tratar los datos");
            }
        },filtro);
    }
    @Override
    public void getPeliculasFiltroCategoria(){
        HashMap<String, String> filtroId = new HashMap<>();
        filtroId.put("acción", "1");
        filtroId.put("aventura", "2");
        filtroId.put("terror", "3");
        filtroId.put("ciencia ficcion", "4");
        modelListaPeliculas.getPeliculasFilterWS(new ContratoListaPeliculas.Model.OnLstPeliculasListener() {
            @Override
            public void onResolve(ArrayList<Pelicula> peliculas) {
                listaVideojuegos.success(peliculas);
            }

            @Override
            public void onReject(String error) {
                listaVideojuegos.error("Error al tratar los datos");
            }
        }, filtroId.get(filtro));
    }
    @Override
    public void getPeliculasOrdenVoto() {
        modelListaPeliculas.getPeliculasOrdenWS(new ContratoListaPeliculas.Model.OnLstPeliculasListener() {
            @Override
            public void onResolve(ArrayList<Pelicula> peliculas) {
                listaVideojuegos.success(peliculas);
            }

            @Override
            public void onReject(String error) {
                listaVideojuegos.error("Error al tratar los datos");
            }
        });
    }
    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}
