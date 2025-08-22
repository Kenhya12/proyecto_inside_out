package com.insideout.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class MomentoTest {
    private Momento momento;
    private final String titulo = "Un buen día";
    private final String descripcion = "Pasando tiempo en el parque.";
    private final Emotion emocion = Emotion.ALEGRIA;
    private final Sentimiento sentimiento = Sentimiento.BUENO;

    @BeforeEach
    void setUp() {
        // Se crea un Momento para cada test usando las variables de la clase
        momento = new Momento(titulo, descripcion, LocalDateTime.now(), emocion, sentimiento);
    }

    @Test
    void testMomentoCreation() {
        assertNotNull(momento);
        assertEquals(titulo, momento.getTitulo());
        assertEquals(descripcion, momento.getDescripcion());
        assertEquals(emocion, momento.getEmocion());
        assertEquals(sentimiento, momento.getSentimiento());
    }

    @Test
    void testMomentoWithCustomIdCreation() {
        int customId = 10;
        Momento momentoConId = new Momento(customId, titulo, descripcion, LocalDateTime.now(), emocion, sentimiento);

        assertNotNull(momentoConId);
        assertEquals(customId, momentoConId.getId());
        assertEquals(titulo, momentoConId.getTitulo());
        assertEquals(descripcion, momentoConId.getDescripcion());
        assertEquals(emocion, momentoConId.getEmocion());
        assertEquals(sentimiento, momentoConId.getSentimiento());
    }

    @Test
    void testMomentoConIdManual() {
        // Arrange
        int id = 10;
        String tituloManual = "Segundo momento";
        String descripcionManual = "Un recuerdo que ya tengo.";
        LocalDateTime fecha = LocalDateTime.now().minusDays(1);
        Emotion emocionManual = Emotion.TRISTEZA;
        Sentimiento sentimientoManual = Sentimiento.MALO;

        // Act
        // Se usan las variables de la sección Arrange para crear el objeto
        Momento momentoManual = new Momento(id, tituloManual, descripcionManual, fecha, emocionManual,
                sentimientoManual);

        // Assert
        assertEquals(id, momentoManual.getId());
        assertEquals(tituloManual, momentoManual.getTitulo());
        assertEquals(descripcionManual, momentoManual.getDescripcion());
        assertEquals(fecha, momentoManual.getFecha());
        assertEquals(emocionManual, momentoManual.getEmocion());
        assertEquals(sentimientoManual, momentoManual.getSentimiento());
    }
}
