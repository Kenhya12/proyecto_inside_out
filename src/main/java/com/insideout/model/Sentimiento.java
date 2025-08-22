package com.insideout.model;

public enum Sentimiento {
    BUENO("Bueno"),
    MALO("Malo");

    private final String nombre;

    Sentimiento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
