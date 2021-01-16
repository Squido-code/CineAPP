package com.guillermo.cine.listaPeliculas.model;

import android.os.AsyncTask;

import com.guillermo.cine.beans.Pelicula;
import com.guillermo.cine.listaPeliculas.contract.ContratoListaPeliculas;
import com.guillermo.cine.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ModelListaPeliculas
        implements ContratoListaPeliculas.Model {
    private String url;
    private ArrayList<Pelicula> listaArrayJuegos;
    private OnLstPeliculasListener onLstPeliculasListener;


    @Override
    public void getPeliculasWS(OnLstPeliculasListener onLstPeliculasListener) {
        this.onLstPeliculasListener = onLstPeliculasListener;
        url = "https://api.rawg.io/api/games?platforms=4&key=0b839d953789459bba3eac8865198928";
        TareasegudoPlano task = new TareasegudoPlano();
        task.execute();
    }

    @Override
    public void getPeliculasFilterWS(OnLstPeliculasListener onLstPeliculasListener, String filtro) {
        this.onLstPeliculasListener = onLstPeliculasListener;
        String urlBase = "https://api.rawg.io/api/games?platforms=4&key=0b839d953789459bba3eac8865198928";
        String urlFiltro = "&genres=" + filtro;
        url = urlBase + urlFiltro;
        TareasegudoPlano task = new TareasegudoPlano();
        task.execute();
    }


    class TareasegudoPlano extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            Post post = new Post();
            try {
                JSONObject objectJuegos = post.getServerDataGetObject(url);
                JSONArray listaJuegos = objectJuegos.getJSONArray("results");
                listaArrayJuegos = Pelicula.getArrayListFromJSON(listaJuegos);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            if (listaArrayJuegos != null && listaArrayJuegos.size() > 0) {
                onLstPeliculasListener.onResolve(listaArrayJuegos);
            } else {
                onLstPeliculasListener.onReject("Error al traer los datos del servidor");
            }
        }
    }
}

