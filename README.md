Project Inside Out
Instrucciones

Se os ha encargado la creación de una aplicación de consola con la cual el usuario podrá gestionar momentos vividos, Mi Diario. Cada momento tendrá una emoción asignada junto con la fecha de cuando ocurrio.

Cada momento vivído tendrá un identificador, un título, una descripción, una emoción, fecha del momento, fecha de creación, fecha de modificación.

Listado de emociones:

    Alegría
    Tristeza
    Ira
    Asco
    Miedo
    Ansiedad
    Envidia
    Vergüenza
    Aburrimiento
    Nostalgia

Por cada historia de usuario se deberán redactar los criterios de aceptación.

Historias de usuario

    COMO usuario QUIERO añadir un momento vivido PARA poder visualisarlo cuando lo necesite recordar

    COMO usuario QUIERO recuperar la lista de lo momentos vividos registrados PARA poder repasarlos

    COMO usuario QUIERO suprimir un momento vivido PARA evitar duplicados y mantener la lista de momentos organizada

    COMO usuario QUIERO obtener los momentos vividos según su emoción PARA poder visualizarlos

    COMO usuario QUIERO obtener los momentos vividos en un mes determinado

    COMO usuario QUIERO salir del programa PARA poder iniciar otro

My diario:
1. Añadir momento
2. Ver todos los momentos disponibles
3. Eliminar un momento
4. Filtrar los momentos
5. Salir
Seleccione una opción: 1

Ingrese el título: Un día en el parque de atracciones
Ingresa la fecha (dd/mm/year): 01/05/2024
Ingrese la descripción: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus sed eros vel massa scelerisque convallis interdum ut purus.

Selecciona una emoción:
1. Alegría
2. Tristeza
3. Ira
4. Asco
5. Miedo
6. Ansiedad
7. Envidia
8. Vergüenza
9. Aburrimiento
10. Nostalgia
Ingrese su opción: 1
Momento vivído añadido correctamente.

My diario:
1. Añadir momento
2. Ver todos los momentos disponibles
3. Eliminar un momento
4. Filtrar los momentos
5. Salir
Seleccione una opción: 2

Lista de momentos vividos:
1. Ocurrio el: 01/01/2024. Título: Un día en el parque de atracciones. Descripción: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus sed eros vel massa scelerisque convallis interdum ut purus. Emoción: Alegría

My diario:
1. Añadir momento
2. Ver todos los momentos disponibles
3. Eliminar un momento
4. Filtrar los momentos
5. Salir
Seleccione una opción: 3

Ingresa el identificador del momento: 1
Momento vivído eliminado correctamente.

My diario:
1. Añadir momento
2. Ver todos los momentos disponibles
3. Eliminar un momento
4. Filtrar los momentos
5. Salir
Seleccione una opción: 4

Filtar por ...:
1. Emoción
2. Fecha
Ingrese una opción: 1

Selecciona una emoción:
1. Alegría
2. Tristeza
3. Ira
4. Asco
5. Miedo
6. Ansiedad
7. Envidia
8. Vergüenza
9. Aburrimiento
10. Nostalgia
Ingrese su opción: 1

Lista de momentos vividos:
1. Ocurrio el: 01/01/2024. Título: Un día en el parque de atracciones. Descripción: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus sed eros vel massa scelerisque convallis interdum ut purus. Emoción: Alegría

My diario:
1. Añadir momento
2. Ver todos los momentos disponibles
3. Eliminar un momento
4. Filtrar los momentos
5. Salir
Seleccione una opción: 4

Filtrar por ...:
1. Emoción
2. Fecha
Ingrese una opción: 2

Ingrese la fecha (dd/mm/year): 01/01/2024

Lista de momentos vividos:
1. Ocurrio el: 01/01/2024. Título: Un día en el parque de atracciones. Descripción: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus sed eros vel massa scelerisque convallis interdum ut purus. Emoción: Alegría

My diario:
1. Añadir momento
2. Ver todos los momentos disponibles
3. Eliminar un momento
4. Filtrar los momentos
5. Salir
Seleccione una opción: 5

Hasta la próxima!!!

🏁 Rúbrica de evaluación

    Interfaz de usuario
        La interfaz de usuario permite añadir (10%)
        La interfaz de usuario permite visualizar todos los momentos (10%)
        La interfaz de usuario permite eliminar un momento (10%)
        La interfaz de usuario permite filtrar por emoción (10%)
        La interfaz de usuario permite filtrar por fecha (10%)

    Persistencia de datos
        Se hace un uso adecuado de la interface List<E>. (10%)

    Código y Buenas Prácticas
        Tests de cobertura mínimo un 70% (20%)
        El código está bien estructurado (10%)
        Correcta separación de responsabiidades. S de "SOLID" (10%)

-------------------------------------------------------------------
-------------------------------------------------------------------

Nuevos requisitos:

    Listado de los nuevos requisitos
INSIDE-OUT - New Sprint


Features a implementar:

- Distinguir entre momento buenos y malos
- Filtrar por momento buenos o malos
- El usuario podrá generar un archivo CSV de los momentos vivídos
- Además de momentos vividos ahora el diario debe poder registrar películas vistas
- Para añadir una película se necesitará … (2 Opciones disponibles):
- Dificultad Media - En el caso de consumir la API: el id de Imdb (Ej: https://www.imdb.com/es-es/title/tt0118583/?ref_=fn_all_ttl_1)
- Si no se consume la API: Id de Imdb, el título, el género/os, la emoción que nos provocó, año de estreno.
- Un filtro de películas por género
- Se guardará las películas únicamente en un archivo CSV
- Se deberá obtener los datos de una API si elegimos obtener los datos de ella (https://www.freepublicapis.com/free-movie-api)

Se deberá guardar los siguientes campos:
- ImdbId
- Título
- Género o Géneros
- Emoción
- Fecha de estreno (release year)
- Fecha de creación
- Se podrá solicitar el listado de películas
- Se podrá eliminar una película

-----------------------------------------------------------------------------------------------------------
Enlaces:

    Repositorio del proyecto
    Java User Input
    Unit Testing of System.out.print

Entregables:

    Enlace al repositorio original del proyecto de GitHub
    Enlaces de los forks de los compañeros
    El Readme deberá estar debidamente trabajado (Ver Secciones del Readme)
    Enlace a la presentación del proyecto

Secciones del Readme: 

    Título
    Descripción con sinopsis del proyecto
    Pre-requisitos (Que se necesita instalar para poder ejecutar el proyecto)
    Pasos para la instalación
    Ejecución de los tests (Captura de la cobertura)
    Diagramas realizados
    Autores