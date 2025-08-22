package com.insideout.repository;

import com.insideout.model.Emotion;
import com.insideout.model.Momento;
import com.insideout.model.Sentimiento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DiarioRepositoryTest {

    private DiarioRepository diarioRepository;

    @BeforeEach
    void setUp() {
        // Usa una de las dos implementaciones, por ejemplo, la de memoria
        diarioRepository = new DiarioEnMemoria();
    }

    @Test
    void testAddMomento() {
        Momento momento = new Momento("Título", "Descripción", LocalDateTime.now(), Emotion.ALEGRIA, Sentimiento.BUENO);
        diarioRepository.addMomento(momento);
        List<Momento> momentos = diarioRepository.getTodosLosMomentos();
        assertFalse(momentos.isEmpty());
        assertEquals(1, momentos.size());
    }

    @Test
    void testEliminarMomentoExistente() {
        Momento momento = new Momento("Título", "Descripción", LocalDateTime.now(), Emotion.TRISTEZA, Sentimiento.MALO);
        diarioRepository.addMomento(momento);
        assertTrue(diarioRepository.eliminarMomento(momento.getId()));
        assertTrue(diarioRepository.getTodosLosMomentos().isEmpty());
    }

    @Test
    void testEliminarMomentoInexistente() {
        assertFalse(diarioRepository.eliminarMomento(999));
    }

    @Test
    void testGetMomentosByEmocion() {
        diarioRepository.addMomento(
                new Momento("Feliz", "Día soleado", LocalDateTime.now(), Emotion.ALEGRIA, Sentimiento.BUENO));
        diarioRepository
                .addMomento(new Momento("Triste", "Lluvia", LocalDateTime.now(), Emotion.TRISTEZA, Sentimiento.MALO));
        List<Momento> alegres = diarioRepository.getMomentosByEmocion(Emotion.ALEGRIA);
        assertEquals(1, alegres.size());
        assertEquals("Feliz", alegres.get(0).getTitulo());
    }
}
