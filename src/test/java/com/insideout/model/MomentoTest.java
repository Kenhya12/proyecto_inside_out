package com.insideout.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class MomentoTest {

    @Test
    void testMomentoConIdAutomatico() {
        // Arrange
        String titulo = "Mi primer momento";
        String descripcion = "Escribiendo mi primer recuerdo.";
        LocalDateTime fecha = LocalDateTime.now();
        Emotion emocion = Emotion.ALEGRIA;

        // Act
        Momento momento = new Momento(titulo, descripcion, fecha, emocion);

        // Assert
        assertNotNull(momento.getId());
        assertEquals(titulo, momento.getTitulo());
        assertEquals(descripcion, momento.getDescripcion());
        assertEquals(fecha, momento.getFecha());
        assertEquals(emocion, momento.getEmocion());
    }

    @Test
    void testMomentoConIdManual() {
        // Arrange
        int id = 10;
        String titulo = "Segundo momento";
        String descripcion = "Un recuerdo que ya tengo.";
        LocalDateTime fecha = LocalDateTime.now().minusDays(1);
        Emotion emocion = Emotion.TRISTEZA;

        // Act
        Momento momento = new Momento(id, titulo, descripcion, fecha, emocion);

        // Assert
        assertEquals(id, momento.getId());
        assertEquals(titulo, momento.getTitulo());
        assertEquals(descripcion, momento.getDescripcion());
        assertEquals(fecha, momento.getFecha());
        assertEquals(emocion, momento.getEmocion());
    }
}
