package com.guillermo.cine.fichaDescriptiva.model;

import android.os.AsyncTask;

import com.guillermo.cine.beans.Ficha;
import com.guillermo.cine.fichaDescriptiva.contract.ContratoFichaDescriptiva;
import com.guillermo.cine.utils.Post;

import org.json.JSONObject;

public class ModelFichaDescriptiva implements ContratoFichaDescriptiva.Model {
    //    https://api.rawg.io/api/games/ + id del juego
    private final String URL = "https://api.rawg.io/api/games/";
    private Ficha fichaCompleta;
    private OnLstFichaListener onLstFichaListener;
    private String idFicha;

    @Override
    public void getDescripcionWS(OnLstFichaListener onLstFichaListener, String idFicha) {
        this.onLstFichaListener = onLstFichaListener;
        this.idFicha = idFicha;
        TareasegudoPlano task = new TareasegudoPlano();
        task.execute();
    }

    class TareasegudoPlano extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {

            Post post = new Post();
            String UrlCompleta = URL + idFicha;
            JSONObject objectFicha = post.getServerDataGetObject(UrlCompleta);
            fichaCompleta = Ficha.getFichafromJSONObject(objectFicha);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            if (fichaCompleta != null) {
                onLstFichaListener.onResolve(fichaCompleta);
            } else {
                onLstFichaListener.onReject("Error al traer los datos del servidor");
            }
        }
    }
}
