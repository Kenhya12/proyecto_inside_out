package com.insideout.controller;

import com.insideout.dto.MomentoDTO;
import com.insideout.mapper.MomentoMapper;
import com.insideout.model.Emotion;
import com.insideout.model.Momento;
import com.insideout.model.Sentimiento;
import com.insideout.repository.DiarioRepository;
import com.insideout.view.ConsolaView;

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
                    verMomentosPorSentimiento(); 
                    break;
                case 6:
                    salir = true;
                    consolaView.mostrarMensaje("\nHasta la próxima!!!");
                    break;
                default:
                    consolaView.mostrarMensaje("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }

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
        // Muestra todos los momentos para que el usuario pueda ver los IDs
        verTodosLosMomentos();

        // Solicita el ID del momento a eliminar
        int id = consolaView.solicitarIdMomento();

        // Intenta eliminar el momento y muestra el resultado
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
                verMomentosPorFecha();
                break;
            case 3:
                verMomentosPorMesYAnio();
                break;
            default:
                consolaView.mostrarMensaje("Opción de filtro no válida.");
                break;
        }
    }

    // Método para filtrar por emoción
    private void verMomentosPorEmocion() {
        String emocionStr = consolaView.solicitarEmocion();
        try {
            Emotion emocion = Emotion.valueOf(emocionStr.toUpperCase());
            List<Momento> momentos = diarioRepository.getMomentosByEmocion(emocion);
            List<MomentoDTO> dtos = MomentoMapper.toDTOList(momentos);

            consolaView.mostrarMomentos(dtos);

            // Si hay momentos, preguntar si se desea eliminar uno
            if (!momentos.isEmpty()) {
                String confirmacion = consolaView.solicitarConfirmacion("¿Deseas eliminar uno de estos momentos?");
                if (confirmacion.equals("s")) {
                    int id = consolaView.solicitarIdMomento();
                    boolean eliminado = diarioRepository.eliminarMomento(id);
                    if (eliminado) {
                        consolaView.mostrarMensaje("Momento eliminado con éxito.");
                    } else {
                        consolaView.mostrarMensaje("No se encontró un momento con el ID proporcionado.");
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            consolaView.mostrarMensaje("La emoción ingresada no es válida.");
        }
    }

    // Método para filtrar por fecha
    private void verMomentosPorFecha() {
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

    // Método para filtrar por mes y año
    private void verMomentosPorMesYAnio() {
        int mes = consolaView.solicitarMes();
        int anio = consolaView.solicitarAnio();
        List<Momento> momentos = diarioRepository.getMomentosByMesAndAnio(mes, anio);
        List<MomentoDTO> dtos = MomentoMapper.toDTOList(momentos);
        consolaView.mostrarMomentos(dtos);
    }

    // Método para filtrar por sentimiento
    private void verMomentosPorSentimiento() {
        try {
            String sentimientoStr = consolaView.solicitarSentimiento();
            Sentimiento sentimiento = Sentimiento.valueOf(sentimientoStr.toUpperCase());
            List<Momento> momentos = diarioRepository.getMomentosBySentimiento(sentimiento);
            List<MomentoDTO> dtos = MomentoMapper.toDTOList(momentos);
            consolaView.mostrarMomentos(dtos);
    
            if (!momentos.isEmpty()) {
                String confirmacion = consolaView.solicitarConfirmacion("¿Deseas eliminar uno de estos momentos?");
                if (confirmacion.equalsIgnoreCase("s")) {
                    int id = consolaView.solicitarIdMomento();
                    boolean eliminado = diarioRepository.eliminarMomento(id);
                    if (eliminado) {
                        consolaView.mostrarMensaje("Momento eliminado con éxito.");
                    } else {
                        consolaView.mostrarMensaje("No se encontró un momento con el ID proporcionado.");
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            consolaView.mostrarMensaje("El sentimiento ingresado no es válido.");
        }
    }
}

