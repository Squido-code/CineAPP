package com.guillermo.cine.beans;

import org.json.JSONException;
import org.json.JSONObject;

public class Ficha {

    private String nombre;
    private String description;
    private String urlImagen;


    public static Ficha getFichafromJSONObject(JSONObject jsonObject) {
        Ficha ficha = new Ficha();
        try {
            String nombre = jsonObject.getString("name");
            String description = jsonObject.getString("description");
            String urlImagen = jsonObject.getString("background_image");
            ficha.setNombre(nombre);

            ficha.setDescription(description);
            ficha.setUrlImagen(urlImagen);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ficha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
