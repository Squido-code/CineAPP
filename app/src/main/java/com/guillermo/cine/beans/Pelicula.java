package com.guillermo.cine.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pelicula {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String BACKGROUND_IMAGE = "background_image";
    private String id;
    private String nombre;
    private String description;
    private String imagen;


    public static ArrayList<Pelicula> getArrayListFromJSON(JSONArray listaJuegos) {
        ArrayList<Pelicula> lista = null;
        try {
            if (listaJuegos != null && listaJuegos.length() > 0) {
                lista = new ArrayList<Pelicula>();
            }
            for (int i = 0; i < listaJuegos.length(); i++) {
                JSONObject json_data = listaJuegos.getJSONObject(i);
                Pelicula pelicula = new Pelicula();

                pelicula.setId(json_data.getString(ID));
                pelicula.setNombre(json_data.getString(NAME));
                pelicula.setImagen(json_data.getString(BACKGROUND_IMAGE));

                lista.add(pelicula);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
