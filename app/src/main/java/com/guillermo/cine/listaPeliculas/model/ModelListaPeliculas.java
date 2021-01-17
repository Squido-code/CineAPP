package com.guillermo.cine.listaPeliculas.model;

import android.os.AsyncTask;

import com.guillermo.cine.beans.Pelicula;
import com.guillermo.cine.listaPeliculas.contract.ContratoListaPeliculas;
import com.guillermo.cine.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ModelListaPeliculas
        implements ContratoListaPeliculas.Model {
    private String url;
    private ArrayList<Pelicula> listaArrayPeliculas;
    private OnLstPeliculasListener onLstPeliculasListener;


    @Override
    public void getPeliculasWS(OnLstPeliculasListener onLstPeliculasListener) {
        this.onLstPeliculasListener = onLstPeliculasListener;
        url = "http://192.168.1.134:8080/Controller?ACTION=PELICULA.FIND_ALL";
        TareaSegudoPlano task = new TareaSegudoPlano();
        task.execute();
    }

    @Override
    public void getPeliculasFilterWS(OnLstPeliculasListener onLstPeliculasListener, String filtro) {
        this.onLstPeliculasListener = onLstPeliculasListener;
        String urlBase = "https://api.rawg.io/api/games?platforms=4&key=0b839d953789459bba3eac8865198928";
        String urlFiltro = "&genres=" + filtro;
        url = urlBase + urlFiltro;
        TareaSegudoPlano task = new TareaSegudoPlano();
        task.execute();
    }


    class TareaSegudoPlano extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            Post post = new Post();
//            HashMap<String,String> parametros = new HashMap();
//            parametros.put("ACTION","PELICULA.FIND_ALL");
            JSONArray listaPeliculas = post.getServerDataGet(url);
            //JSONArray listaPeliculas = objectPeliculas.getJSONArray("");
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

