package com.insideout.view;

import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.insideout.dto.MomentoDTO;
import com.insideout.model.Emotion;

public class ConsolaView {
    private final Scanner scanner = new Scanner(System.in);
    // private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Método que FALTA en tu ConsolaView original
    public int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    public void mostrarMenuPrincipal() {
        System.out.println("\nMy diario:");
        System.out.println("1. Añadir momento");
        System.out.println("2. Ver todos los momentos disponibles");
        System.out.println("3. Eliminar un momento");
        System.out.println("4. Filtrar los momentos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public MomentoDTO solicitarDatosMomento() {
    System.out.print("\nIngrese el título: ");
    String titulo = scanner.nextLine();
    
    System.out.print("Ingresa la fecha (dd/mm/yyyy): ");
    String fechaStr = scanner.nextLine(); // Esto ya está en formato dd/MM/yyyy
    
    System.out.print("Ingrese la descripción: ");
    String descripcion = scanner.nextLine();
    
    Emotion emocion = solicitarEmocionMenu();
    
    // Envía la fecha directamente en formato dd/MM/yyyy (sin convertir a ISO)
    return new MomentoDTO(0, titulo, descripcion, fechaStr, emocion.name());
}

    private Emotion solicitarEmocionMenu() {
        System.out.println("\nSelecciona una emoción:");
        Emotion[] emociones = Emotion.values();
        for (int i = 0; i < emociones.length; i++) {
            System.out.println((i + 1) + ". " + emociones[i].getName());
        }
        
        System.out.print("Ingrese su opción: ");
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion >= 1 && opcion <= emociones.length) {
                return emociones[opcion - 1];
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }
        
        System.out.println("Opción inválida, seleccionando Alegría por defecto");
        return Emotion.ALEGRIA;
    }

    private LocalDateTime parseFecha(String fechaStr) {
    try {
        // Parsear formato dd/MM/yyyy
        String[] partes = fechaStr.split("/");
        if (partes.length == 3) {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int anio = Integer.parseInt(partes[2]);
            return LocalDateTime.of(anio, mes, dia, 0, 0);
        }
    } catch (Exception e) {
        System.out.println("Fecha inválida: " + fechaStr);
    }
    
    System.out.println("Usando fecha actual por defecto");
    return LocalDateTime.now();
} 

    public int solicitarIdMomento() {
        System.out.print("\nIngresa el identificador del momento: ");
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            return id;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    public int mostrarMenuFiltros() {
        System.out.println("\nFiltrar por ...:");
        System.out.println("1. Emoción");
        System.out.println("2. Fecha");
        System.out.print("Ingrese una opción: ");
        
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    public String solicitarEmocion() {
        System.out.print("Ingrese la emoción (ALEGRIA, TRISTEZA, IRA, ASCO, MIEDO, ANSIEDAD, ENVIDIA, VERGUENZA, ABURRIMIENTO, NOSTALGIA): ");
        return scanner.nextLine().toUpperCase();
    }

    public String solicitarFechaFiltro() {
        System.out.print("\nIngrese la fecha (dd/mm/yyyy): ");
        return scanner.nextLine();
    }

    public void mostrarMomentos(List<MomentoDTO> momentos) {
        if (momentos.isEmpty()) {
            System.out.println("No hay momentos registrados.");
        } else {
            System.out.println("\nLista de momentos vividos:");
            for (MomentoDTO momento : momentos) {
                System.out.println(momento.toString());
            }
        }
    }

    // Método original de tu ConsolaView (para mantener compatibilidad)
    public void mostrarMenu() {
        mostrarMenuPrincipal();
    }
} 
