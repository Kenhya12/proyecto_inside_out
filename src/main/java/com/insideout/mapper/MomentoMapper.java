package com.insideout.mapper;

import com.insideout.dto.MomentoDTO;
import com.insideout.model.Momento;
import com.insideout.model.Emotion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class MomentoMapper {
    private static final DateTimeFormatter DISPLAY_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static MomentoDTO toDTO(Momento momento) {
        return new MomentoDTO(
            momento.getId(),
            momento.getTitulo(),
            momento.getDescripcion(),
            momento.getFecha().format(DISPLAY_FORMATTER),
            momento.getEmocion().getName()
        );
    }

public static Momento toEntity(MomentoDTO dto) {
        try {
            // Parsear la fecha del formato dd/MM/yyyy
            LocalDateTime fecha = LocalDateTime.parse(dto.getFecha() + "T00:00:00", 
                DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm:ss"));
            
            return new Momento(
                dto.getTitulo(),
                dto.getDescripcion(),
                fecha,
                Emotion.valueOf(dto.getEmocion().toUpperCase())
            );
        } catch (Exception e) {
            System.out.println("Error parsing date: " + dto.getFecha() + ", using current date");
            return new Momento(
                dto.getTitulo(),
                dto.getDescripcion(),
                LocalDateTime.now(),
                Emotion.valueOf(dto.getEmocion().toUpperCase())
            );
        }
    }
    
    public static List<MomentoDTO> toDTOList(List<Momento> momentos) {
        return momentos.stream()
                .map(MomentoMapper::toDTO)
                .collect(Collectors.toList());
    }
} 