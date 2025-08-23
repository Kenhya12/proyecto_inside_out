# Inside Out: Diario de Emociones

## Autor: Paula Apsé

Este proyecto es una aplicación de consola en Java que funciona como un diario personal. Permite a los usuarios registrar, consultar y gestionar sus "momentos" diarios, incluyendo la fecha, un título, una descripción, la emoción principal asociada y si fue una experiencia buena o mala. La aplicación está diseñada para ser una herramienta sencilla y efectiva para la autorreflexión y el registro de emociones.

## Pre-requisitos

Para poder ejecutar el proyecto, es necesario tener instalado:

    * Java Development Kit (JDK): El proyecto está construido con Java 21, requiere el entorno de desarrollo para compilar y ejecutar el código.

    * Extension Pack for Java en VS Code: Es un paquete de extensiones que incluye soporte para Java, Maven, Debugger, etc.

    * Apache Maven: Se utiliza como una herramienta de construcción y gestión de dependencias. Maven se encargará de descargar y gestionar automáticamente las librerías de terceros necesarias para el proyecto.

    * JUnit 5 y Hamcrest: Son librerías que se utilizan para crear y ejecutar las pruebas unitarias, son un requisito fundamental para el correcto funcionamiento de los tests.

Según el avance del proyecto, no fue necesaria la instalación de APIs, plugins ni de dependencias adicionales.

## 🚀 Diagrama de clases


```mermaid

---
config:
  theme: mc
  layout: elk
---
classDiagram
direction LR
    class DiarioEnMemoria {
	    - List momentos
	    - static Atomicinteger counter
	    + DiarioEnMemoria()
	    + addMomento(momento momento) : void
	    + eliminarMomento(int id) : boolean
	    + getTodosLosMomentos() : List
	    getMomentoByld(int id) : Momento
	    + getMomentosByEmocion(Emotion emocion) : List
	    +getmomentosBySentimiento(Sentimiento sentimiento) : List
    }
    class DiarioRepository {
	    + addMomento(Momento momento) : void
	    + eliminarmomento(int id) : boolean
	    + getTodosLosMomentos() : List
	    getMomentoByd(int id) : Momento
	    + getMomentosByEmocion(Emotion emocion) : List
	    + getMomentosBySentimiento(Sentimiento sentimiento) : List
    }
    class MomentoController {
	    - DiarioRepository diarioRepository
	    - ConsolaView consolaView
	    - MomentoController()
	    - Iniciar() : void
	    - registrarMomento() : void
	    - verTodosLosMomentos() :void
	    - eliminarMomento() : void
	    - filtrarMomentos() : void
	    - verMomentosporEmocion() : void
	    verMomentosporSentimiento() : void
    }
    class Momento {
	    - final int id
	    - final String titulo
	    - final String descripcion
	    - final LocalDateTime fecha
	    - final Emotion emocion
	    - final Sentimiento sentimiento
	    + Momento()
	    + getters()
	    + toString()
    }
    class ConsolaView {
	    - Scanner scanner
	    + ConsolaView()
	    + mostrarMenuPrincipal() : void
	    + solicitarDatosMomento() : momentoDTO
	    + solicitarOpcion() : String
	    + mostrarMomentos(List momentos) : void
	    + mostrarmensaje(String mensaje) : void
	    + solicitarIdMomento() : int
	    + solicitarEmocion() : Emotion
	    + solicitarSentimiento() : Sentimiento
	    + solicitarConfirmacion() : boolean
    }
    class App {
	    +Main()
    }
    class Emotion {
	    ALEGRÍA
	    TRISTEZA
	    IRA
	    ASCO
	    MIEDO
	    ANSIEDAD
	    ENVIDIA
	    VERGUENZA
	    ABURRIMIENTO
	    NOSTALGIA
	    + getName() : String
    }
    class Sentimiento {
	    BUENO
	    MALO
	    + getNombre() :String
    }
    class MomentoDTO {
	    - int id
	    - String titulo
	    - String descripción
	    - String fecha
	    - String emocion
	    - String sentimiento
	    + MomentoDTO()
	    + getters()
	    + setters()
	    + toString()
    }
    class MomentoMapper {
	    + toDTO(Momento momento) : MomentoDTO
	    + toEntity(MomentoDTO dto) : Momento
	    + toDTOList(List momentos) : List
    }

    MomentoController --* ConsolaView
    MomentoController --* DiarioRepository
    DiarioEnMemoria --* DiarioRepository
    Emotion --o Momento
    Sentimiento --o Momento
    ConsolaView --* Emotion
    ConsolaView --* Sentimiento
    ConsolaView --* Momento
    ConsolaView --* MomentoDTO
    MomentoController --* MomentoDTO
    Momento --o DiarioRepository
    MomentoController --* MomentoMapper
    MomentoMapper --* Momento
    MomentoMapper --* MomentoDTO
    App --* MomentoController

	class MomentoController:::Aqua
	class Momento:::Peach
	class ConsolaView:::Sky
	class App:::Class_02
	class Emotion:::Ash
	class Emotion:::Peach
	class Sentimiento:::Peach

	classDef Ash :,stroke-width:1px, stroke-dasharray:none, stroke:#999999, fill:#EEEEEE, color:#000000
	classDef Peach :,stroke-width:1px, stroke-dasharray:none, stroke:#FBB35A, fill:#FFEFDB, color:#8F632D
	classDef Sky :,stroke-width:1px, stroke-dasharray:none, stroke:#374D7C, fill:#E2EBFF, color:#374D7C
	classDef Aqua :,stroke-width:1px, stroke-dasharray:none, stroke:#46EDC8, fill:#DEFFF8, color:#378E7A
	classDef Class_02 :,stroke-width:4px, stroke-dasharray: 0

    ```





