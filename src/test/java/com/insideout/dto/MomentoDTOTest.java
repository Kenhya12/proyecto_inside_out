package com.insideout.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MomentoDTOTest {

    @Test
    void testConstructorConArgumentos() {
        MomentoDTO dto = new MomentoDTO(1, "Título", "Descripción", "21/08/2025", "ALEGRIA", "BUENO");
        assertEquals(1, dto.getId());
        assertEquals("Título", dto.getTitulo());
        assertEquals("Descripción", dto.getDescripcion());
        assertEquals("21/08/2025", dto.getFecha());
        assertEquals("ALEGRIA", dto.getEmocion());
        assertEquals("BUENO", dto.getSentimiento());
    }

    @Test
    void testGettersAndSetters() {
        MomentoDTO dto = new MomentoDTO(0, "", "", "", "", ""); // Se utiliza un constructor válido para inicializar
        dto.setId(2);
        dto.setTitulo("Título 2");
        dto.setDescripcion("Descripción 2");
        dto.setFecha("22/08/2025");
        dto.setEmocion("TRISTEZA");
        dto.setSentimiento("MALO");

        assertEquals(2, dto.getId());
        assertEquals("Título 2", dto.getTitulo());
        assertEquals("Descripción 2", dto.getDescripcion());
        assertEquals("22/08/2025", dto.getFecha());
        assertEquals("TRISTEZA", dto.getEmocion());
        assertEquals("MALO", dto.getSentimiento());
    }

    @Test
    void testToString() {
        MomentoDTO dto = new MomentoDTO(3, "Título 3", "Descripción 3", "23/08/2025", "IRA", "MALO");
        String expectedString = "ID: 3, Título: Título 3, Emoción: IRA, Sentimiento: MALO, Fecha: 23/08/2025, Descripción: Descripción 3";
        assertEquals(expectedString, dto.toString());
    }
}
