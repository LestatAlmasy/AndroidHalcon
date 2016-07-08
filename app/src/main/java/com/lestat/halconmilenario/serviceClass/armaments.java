package com.lestat.halconmilenario.serviceClass;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lestat on 08-07-2016.
 */
public class armaments {
    private String codigo;
    private String nombre;
    private String modelo;
    private String fabricante;
    private String estado;
    private int idDisparo;

    public armaments(String codigo, String nombre, String modelo, String fabricante, String estado, int idDisparo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.estado = estado;
        this.idDisparo = idDisparo;
    }

    public armaments(JSONObject objeto){

        try {
            this.codigo = objeto.getString("codigo");
            this.nombre = objeto.getString("nombre");
            this.modelo = objeto.getString("modelo");
            this.fabricante = objeto.getString("fabricante");
            this.estado = objeto.getString("estado");
            this.idDisparo = objeto.getInt("idDisparo");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdDisparo() {
        return idDisparo;
    }

    public void setIdDisparo(int idDisparo) {
        this.idDisparo = idDisparo;
    }
}
