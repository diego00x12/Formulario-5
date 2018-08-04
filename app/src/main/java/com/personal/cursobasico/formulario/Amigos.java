package com.personal.cursobasico.formulario;

import java.util.Date;

/**
 * Created by Ney Casilla on 7/28/2018.
 */

public class Amigos {

    public Amigos(String nombre, String fecha){

        this.nombre=nombre;
        this.fecha=fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    private String nombre;

    private String fecha;
}
