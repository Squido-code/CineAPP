package com.guillermo.cine.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pelicula {
    private static final String ID = "id";
    private static final String NAME = "titulo";
    private static final String SINOPSIS = "sinopsis";
    private static final String BACKGROUND_IMAGE = "background_image";
    private static final String FECHA_ESTRENO = "fechaEstreno";
    private static final String DURACION = "duracion";
    private static final String PRECIO = "precio";

    private String id;
    private String nombre;
    private String sinopsis;
    private String fechaEstreno;
    private String duracion ;
    private String precio;
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
                pelicula.setDuracion(DURACION);
                pelicula.setFechaEstreno(FECHA_ESTRENO);
                pelicula.setPrecio(PRECIO);
                pelicula.setSinopsis(SINOPSIS);

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

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
