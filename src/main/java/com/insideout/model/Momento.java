package com.insideout.model;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Momento {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int id;
    private final String titulo;
    private final String descripcion;
    private final LocalDateTime fecha;
    private final Emotion emocion;
    private final Sentimiento sentimiento;

    public Momento(String titulo, String descripcion, LocalDateTime fecha, Emotion emocion, Sentimiento sentimiento) {
        this.id = counter.incrementAndGet();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.emocion = emocion;
        this.sentimiento = sentimiento;
    }

    public Momento(int id, String titulo, String descripcion, LocalDateTime fecha, Emotion emocion, Sentimiento sentimiento) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.emocion = emocion;
        this.sentimiento = sentimiento;
    }

    // GETTERS (todos deben existir)
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Emotion getEmocion() {
        return emocion;
    }

    public Sentimiento getSentimiento() {
        return sentimiento;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Emoción: " + emocion.getName() + ", Sentimiento: " + sentimiento
                + ", Fecha: " + fecha + ", Descripción: " + descripcion;
    }
}