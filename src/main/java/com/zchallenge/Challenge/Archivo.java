package com.zchallenge.Challenge;

public class Archivo implements EntidadFileSystem{
    private String nombre;

    public Archivo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
