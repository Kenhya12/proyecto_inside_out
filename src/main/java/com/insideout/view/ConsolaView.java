package com.insideout.view;

import com.insideout.dto.MomentoDTO;
import com.insideout.model.Emotion;
import com.insideout.model.Sentimiento;

//import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsolaView {
    private final Scanner scanner = new Scanner(System.in);

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
        String fechaStr = scanner.nextLine();
        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();

        Emotion emocion = solicitarEmocionMenu();
        Sentimiento sentimiento = solicitarSentimientoMenu(); // Nuevo

        // Ahora se pasan 6 parámetros al constructor de MomentoDTO
        return new MomentoDTO(0, titulo, descripcion, fechaStr, emocion.name(), sentimiento.name());
    }

    private Sentimiento solicitarSentimientoMenu() {
        System.out.println("\n¿El momento es bueno o malo?");
        System.out.println("1. Bueno");
        System.out.println("2. Malo");

        System.out.print("Ingrese su opción: ");
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion == 1)
                return Sentimiento.BUENO;
            if (opcion == 2)
                return Sentimiento.MALO;
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }

        System.out.println("Opción inválida, seleccionando Bueno por defecto");
        return Sentimiento.BUENO;
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
        System.out.println("2. Fecha (dd/mm/yyyy)");
        System.out.println("3. Mes y Año");
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
        System.out.print(
                "Ingrese la emoción (Alegría, Tristeza, Ira, Asco, Miedo, Ansiedad, Envidia, Verguenza, Aburrimiento, Nostalgia): ");
        return scanner.nextLine().toUpperCase();
    }

    public String solicitarConfirmacion(String mensaje) {
        System.out.print(mensaje + " (s/n): ");
        return scanner.nextLine().toLowerCase();
    }

    public String solicitarFechaFiltro() {
        System.out.print("\nIngrese la fecha (dd/mm/yyyy): ");
        return scanner.nextLine();
    }

    // Método que solicita el mes y valida la entrada
    public int solicitarMes() {
        while (true) {
            System.out.print("\nIngrese el mes (1-12): ");
            try {
                int mes = Integer.parseInt(scanner.nextLine());
                if (mes >= 1 && mes <= 12) {
                    return mes;
                } else {
                    mostrarMensaje("Mes no válido. Por favor, ingrese un número entre 1 y 12.");
                }
            } catch (NumberFormatException e) {
                mostrarMensaje("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }

    // Método que solicita el año y valida la entrada
    public int solicitarAnio() {
        while (true) {
            System.out.print("Ingrese el año (yyyy): ");
            try {
                int anio = Integer.parseInt(scanner.nextLine());
                if (anio > 0) {
                    return anio;
                } else {
                    mostrarMensaje("Año no válido. Por favor, ingrese un número positivo.");
                }
            } catch (NumberFormatException e) {
                mostrarMensaje("Entrada no válida. Por favor, ingrese un número.");
            }
        }
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
}