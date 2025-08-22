package com.insideout.dto;

public class MomentoDTO {
    private int id;
    private String titulo;
    private String descripcion;
    private String fecha;
    private String emocion;
    private String sentimiento;

    public MomentoDTO(int id, String titulo, String descripcion, String fecha, String emocion, String sentimiento) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.emocion = emocion;
        this.sentimiento = sentimiento;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }

    public String getSentimiento() {
        return sentimiento;
    }

    public void setSentimiento(String sentimiento) {
        this.sentimiento = sentimiento;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Emoción: " + emocion + ", Sentimiento: " + sentimiento
                + ", Fecha: " + fecha + ", Descripción: " + descripcion;
    }
}