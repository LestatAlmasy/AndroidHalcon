package com.lestat.halconmilenario.serviceClass;

/**
 * Created by Lestat on 08-07-2016.
 */
public class users {
    private String user;
    private String pass;
    private String apellidos;
    private String nivelMilitar;
    private int edad;
    private boolean habilitado;

    public users(String user, String pass, String apellidos, String nivelMilitar, int edad, boolean habilitado) {
        this.user = user;
        this.pass = pass;
        this.apellidos = apellidos;
        this.nivelMilitar = nivelMilitar;
        this.edad = edad;
        this.habilitado = habilitado;
    }

    public users(){

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNivelMilitar() {
        return nivelMilitar;
    }

    public void setNivelMilitar(String nivelMilitar) {
        this.nivelMilitar = nivelMilitar;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
}
