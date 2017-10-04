package com.androidapps.guti.clase6_controldinamico;

/**
 * Created by android on 03/10/17.
 */

public class Persona {
    private String nombre;
    private String apellido;

    public void setNombre(String texto1) {
        this.nombre = texto1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String texto2) {
        this.apellido = texto2;
    }

    public String getApellido() {
        return apellido;
    }

    public Persona(String n, String a){
        nombre = n;
        apellido = a;
    }
}
