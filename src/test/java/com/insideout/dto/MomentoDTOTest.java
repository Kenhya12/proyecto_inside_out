package com.insideout.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MomentoDTOTest {

    @Test
    void testConstructorVacio() {
        MomentoDTO dto = new MomentoDTO();
        assertNotNull(dto);
    }

    @Test
    void testConstructorConArgumentos() {
        MomentoDTO dto = new MomentoDTO(1, "Título", "Descripción", "21/08/2025", "ALEGRIA");
        assertEquals(1, dto.getId());
        assertEquals("Título", dto.getTitulo());
        assertEquals("Descripción", dto.getDescripcion());
        assertEquals("21/08/2025", dto.getFecha());
        assertEquals("ALEGRIA", dto.getEmocion());
    }

    @Test
    void testGettersAndSetters() {
        MomentoDTO dto = new MomentoDTO();
        dto.setId(2);
        dto.setTitulo("Título 2");
        dto.setDescripcion("Descripción 2");
        dto.setFecha("22/08/2025");
        dto.setEmocion("TRISTEZA");

        assertEquals(2, dto.getId());
        assertEquals("Título 2", dto.getTitulo());
        assertEquals("Descripción 2", dto.getDescripcion());
        assertEquals("22/08/2025", dto.getFecha());
        assertEquals("TRISTEZA", dto.getEmocion());
    }

    @Test
    void testToString() {
        MomentoDTO dto = new MomentoDTO(3, "Título 3", "Descripción 3", "23/08/2025", "IRA");
        String expectedString = "ID: 3, Título: Título 3, Emoción: IRA, Fecha: 23/08/2025, Descripción: Descripción 3";
        assertEquals(expectedString, dto.toString());
    }
}
