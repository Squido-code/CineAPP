package com.guillermo.cine.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pelicula {
    private static final String ID = "id";
    private static final String NAME = "titulo";
    private static final String SINOPSIS = "sinopsis";
    private static final String BACKGROUND_IMAGE = "cartel";
    private static final String FECHA_ESTRENO = "fechaEstreno";
    private static final String DURACION = "duracion";
    private static final String PRECIO = "precio";
    private static final String HORARIOS = "horarios";

    private String id;
    private String nombre;
    private String sinopsis;
    private String fechaEstreno;
    private String duracion ;
    private String precio;
    private String imagen;
    private ArrayList<String> horarios;

    public Pelicula() {
        this.horarios = new ArrayList<>();
    }

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
                pelicula.setDuracion(json_data.getString(DURACION));
                pelicula.setFechaEstreno(json_data.getString(FECHA_ESTRENO));
                pelicula.setPrecio(json_data.getString(PRECIO));
                pelicula.setSinopsis(json_data.getString(SINOPSIS));


                JSONArray horariosJSON = json_data.getJSONArray(HORARIOS);
                for (int j = 0; j < horariosJSON.length() ; j++) {
                pelicula.getHorarios().add(horariosJSON.getString(j));
                }
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

    public ArrayList<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<String> horarios) {
        this.horarios = horarios;
    }

    public String horariosToString(){
        StringBuilder builder = new StringBuilder();
        for (String hora:
             horarios) {
            builder.append(hora);
            builder.append(" ");
        }

        return "Sesiones: " + builder.toString();
    }
}
