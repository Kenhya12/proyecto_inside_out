package com.insideout.mapper;

import com.insideout.dto.MomentoDTO;
import com.insideout.model.Emotion;
import com.insideout.model.Momento;
import com.insideout.model.Sentimiento;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MomentoMapperTest {

    @Test
    void testToDTO() {
        LocalDateTime now = LocalDateTime.now();
        Momento momento = new Momento(1, "Viaje", "Un gran viaje", now, Emotion.MIEDO, Sentimiento.BUENO);
        MomentoDTO dto = MomentoMapper.toDTO(momento);

        assertNotNull(dto);
        assertEquals(1, dto.getId());
        assertEquals("Viaje", dto.getTitulo());
        assertEquals(momento.getEmocion().getName(), dto.getEmocion());
    }

    @Test
    void testToEntity() {
        String fechaStr = "21/08/2025";
        MomentoDTO dto = new MomentoDTO(0, "Cena", "Cena con amigos", fechaStr, "ALEGRIA", "BUENO");
        Momento momento = MomentoMapper.toEntity(dto);

        assertNotNull(momento);
        assertEquals("Cena", momento.getTitulo());
        assertEquals(Emotion.ALEGRIA, momento.getEmocion());
    }

    @Test
    void testToDTOList() {
        // Arrange: Crea una lista de Momento
        Momento m1 = new Momento(1, "Momento 1", "Descripción 1", LocalDateTime.now(), Emotion.ALEGRIA,
                Sentimiento.BUENO);
        Momento m2 = new Momento(2, "Momento 2", "Descripción 2", LocalDateTime.now(), Emotion.TRISTEZA,
                Sentimiento.MALO);
        List<Momento> momentos = Arrays.asList(m1, m2);

        // Act: Convierte la lista a DTO
        List<MomentoDTO> dtos = MomentoMapper.toDTOList(momentos);

        // Assert: Verifica que la conversión sea correcta
        assertNotNull(dtos);
        assertEquals(2, dtos.size());

        assertEquals(1, dtos.get(0).getId());
        assertEquals("Momento 1", dtos.get(0).getTitulo());
        assertEquals(Emotion.ALEGRIA.getName(), dtos.get(0).getEmocion());

        assertEquals(2, dtos.get(1).getId());
        assertEquals("Momento 2", dtos.get(1).getTitulo());
        assertEquals(Emotion.TRISTEZA.getName(), dtos.get(1).getEmocion());
    }
}
