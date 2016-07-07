package com.lestat.halconmilenario.serviceClass;

/**
 * Created by Lestat on 06-07-2016.
 */
public class events {
    private String categoria;
    private String descripcion;

    public events(String categoria, String descripcion) {
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public events(){

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
