package com.insideout.controller;

import com.insideout.dto.MomentoDTO;
import com.insideout.model.Emotion;
import com.insideout.model.Momento;
import com.insideout.repository.DiarioRepository;
import com.insideout.view.ConsolaView;
import com.insideout.mapper.MomentoMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MomentoController {
    private final DiarioRepository diarioRepository;
    private final ConsolaView consolaView;

    public MomentoController(DiarioRepository diarioRepository, ConsolaView consolaView) {
        this.diarioRepository = diarioRepository;
        this.consolaView = consolaView;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            consolaView.mostrarMenuPrincipal();
            int opcion = consolaView.leerOpcion();
            switch (opcion) {
                case 1:
                    registrarMomento();
                    break;
                case 2:
                    verTodosLosMomentos();
                    break;
                case 3:
                    eliminarMomento();
                    break;
                case 4:
                    filtrarMomentos();
                    break;
                case 5:
                    salir = true;
                    consolaView.mostrarMensaje("\nHasta la próxima!!!");
                    break;
                default:
                    consolaView.mostrarMensaje("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }

    // AÑADE ESTOS MÉTODOS PRIVADOS:
    private void registrarMomento() {
        MomentoDTO dto = consolaView.solicitarDatosMomento();
        try {
            Momento momento = MomentoMapper.toEntity(dto);
            diarioRepository.addMomento(momento);
            consolaView.mostrarMensaje("Momento registrado con éxito.");
        } catch (IllegalArgumentException e) {
            consolaView.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private void verTodosLosMomentos() {
        List<Momento> momentos = diarioRepository.getTodosLosMomentos();
        List<MomentoDTO> dtos = MomentoMapper.toDTOList(momentos);
        consolaView.mostrarMomentos(dtos);
    }

    private void eliminarMomento() {
        int id = consolaView.solicitarIdMomento();
        boolean eliminado = diarioRepository.eliminarMomento(id);
        if (eliminado) {
            consolaView.mostrarMensaje("Momento eliminado con éxito.");
        } else {
            consolaView.mostrarMensaje("No se encontró un momento con el ID proporcionado.");
        }
    }

    private void filtrarMomentos() {
        int opcionFiltro = consolaView.mostrarMenuFiltros();
        switch (opcionFiltro) {
            case 1:
                verMomentosPorEmocion();
                break;
            case 2:
                filtrarPorFecha();
                break;
            default:
                consolaView.mostrarMensaje("Opción de filtro no válida.");
                break;
        }
    }

    private void verMomentosPorEmocion() {
        String emocionStr = consolaView.solicitarEmocion();
        try {
            Emotion emocion = Emotion.valueOf(emocionStr.toUpperCase());
            List<Momento> momentos = diarioRepository.getMomentosByEmocion(emocion);
            List<MomentoDTO> dtos = MomentoMapper.toDTOList(momentos);
            consolaView.mostrarMomentos(dtos);
        } catch (IllegalArgumentException e) {
            consolaView.mostrarMensaje("La emoción ingresada no es válida.");
        }
    }

    private void filtrarPorFecha() {
        String fechaStr = consolaView.solicitarFechaFiltro();
        try {
            LocalDateTime fecha = LocalDateTime.parse(fechaStr + "T00:00:00",
                    DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm:ss"));
            List<Momento> momentos = diarioRepository.getMomentosByFecha(fecha);
            List<MomentoDTO> dtos = MomentoMapper.toDTOList(momentos);
            consolaView.mostrarMomentos(dtos);
        } catch (Exception e) {
            consolaView.mostrarMensaje("Fecha inválida.");
        }
    }
}
