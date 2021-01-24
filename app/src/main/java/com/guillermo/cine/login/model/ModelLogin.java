package com.guillermo.cine.login.model;

import android.os.AsyncTask;

import com.guillermo.cine.beans.Pelicula;
import com.guillermo.cine.login.contract.ContratoLogin;
import com.guillermo.cine.utils.Post;

import org.json.JSONArray;

public class ModelLogin implements ContratoLogin.Model {
    private LoginListener loginListener;
    @Override
    public void checkUser(LoginListener loginListener) {

    }
    class TareaSegudoPlano extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            Post post = new Post();
            post.
            JSONArray listaPeliculas = post.getServerDataGet(url);
            listaArrayPeliculas = Pelicula.getArrayListFromJSON(listaPeliculas);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            if (listaArrayPeliculas != null && listaArrayPeliculas.size() > 0) {
                onLstPeliculasListener.onResolve(listaArrayPeliculas);
            } else {
                onLstPeliculasListener.onReject("Error al traer los datos del servidor");
            }
        }
    }
}
