package com.zchallenge.Challenge;

import java.util.ArrayList;
import java.util.List;

public class Directorio implements EntidadFileSystem{

    private String nombre;
    private Directorio padre;
    private List<EntidadFileSystem> hijos;

    public Directorio(String nombre, Directorio padre) {
        this.nombre = nombre;
        this.padre = padre;
        this.hijos = new ArrayList<EntidadFileSystem>();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public List<EntidadFileSystem> getHijos() {
        return hijos;
    }

    public Directorio getPadre() {
        return padre;
    }
}
