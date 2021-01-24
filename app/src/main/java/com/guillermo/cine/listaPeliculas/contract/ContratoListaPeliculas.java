package com.guillermo.cine.listaPeliculas.contract;

import com.guillermo.cine.beans.Pelicula;

import java.util.ArrayList;

public interface ContratoListaPeliculas {
    interface View {
        void success(ArrayList<Pelicula> peliculas);

        void error(String mensage);

    }

    interface Presenter {
        void getPeliculas();
        void getPeliculasFiltroTexto(String filtro);
        void getPeliculasFiltroCategoria();
        void getPeliculasOrdenVoto();

    }
    interface Model{
        void getPeliculasWS(OnLstPeliculasListener onLstPeliculasListener);

        void getPeliculasFilterWS(OnLstPeliculasListener onLstPeliculasListener, String filtro);

        void getPeliculasTextoWS(OnLstPeliculasListener onLstPeliculasListener, String filtro);

        void getPeliculasOrdenWS(OnLstPeliculasListener onLstPeliculasListener);
        /*Reactivo*/
        interface OnLstPeliculasListener {
            void onResolve(ArrayList<Pelicula> peliculas);

            void onReject(String error);
        }
    }
}
