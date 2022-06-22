package com.techu.recetas.recetas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection ="recetas")
public class RecetaModel {

    @Id
    private String nombre;

    private Integer tiempo;

    private String preparacion;

    private String ingredientes;

    private String foto;

    public RecetaModel() {
    }

    public RecetaModel(String nombre, Integer tiempo, String foto, String preparacion, String ingredientes) {
        this.nombre=nombre;
        this.tiempo = tiempo;
        this.foto = foto;
        this.preparacion = preparacion;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
