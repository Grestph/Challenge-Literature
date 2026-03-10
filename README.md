📚 LiterAlura - Catálogo de Libros
📖 Descripción

LiterAlura es una aplicación desarrollada en Java con Spring Boot que permite construir un catálogo de libros utilizando la API pública de Gutendex (Project Gutenberg).

La aplicación permite consultar libros desde una API externa, procesar la información obtenida, almacenarla en una base de datos PostgreSQL y mostrar los resultados al usuario mediante un menú interactivo en consola.

Este proyecto fue desarrollado como parte del Challenge LiterAlura de Alura Latam.

🚀 Tecnologías utilizadas

Java 17

Spring Boot

Spring Data JPA

PostgreSQL

Jackson (JSON)

Maven

API Gutendex

🌐 API utilizada

La aplicación utiliza la API pública:

https://gutendex.com/books/

Esta API proporciona información de más de 70,000 libros del proyecto Project Gutenberg.

Ejemplo de consulta:

https://gutendex.com/books/?search=don%20quixote
⚙️ Funcionalidades

La aplicación ofrece un menú interactivo con las siguientes opciones:

1 - Buscar libro por título
2 - Listar libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en determinado año
5 - Listar libros por idioma
0 - Salir
🔎 Buscar libro por título

Permite buscar un libro en la API Gutendex ingresando su título.

El sistema:

Consulta la API

Obtiene el primer resultado

Convierte el JSON a objetos Java

Guarda el libro y su autor en la base de datos

📚 Listar libros registrados

Muestra todos los libros que han sido almacenados previamente en la base de datos.

✍️ Listar autores registrados

Permite visualizar todos los autores que han sido guardados en el catálogo.

📅 Listar autores vivos en un determinado año

Permite consultar qué autores estaban vivos en un año específico ingresado por el usuario.

🌍 Listar libros por idioma

Permite mostrar los libros según su idioma:

es - Español
en - Inglés
fr - Francés
pt - Portugués
🗄️ Base de datos

La aplicación utiliza PostgreSQL para almacenar la información.

Tablas principales:

Autor

Libro

Relación:

Autor 1 ----- N Libro
📂 Estructura del proyecto
src
 └─ main
     └─ java
         └─ com.aluradesafio.challengue
             │
             ├─ dto
             │   ├─ DatosAutor
             │   ├─ DatosLibro
             │   └─ DatosResultado
             │
             ├─ model
             │   ├─ Autor
             │   └─ Libro
             │
             ├─ repository
             │   ├─ AutorRepository
             │   └─ LibroRepository
             │
             ├─ service
             │   ├─ ConsumoAPI
             │   └─ ConvierteDatos
             │
             ├─ principal
             │   └─ Principal
             │
             └─ ChallengueApplication
▶️ Cómo ejecutar el proyecto

Clonar el repositorio

git clone https://github.com/tu-usuario/literalura.git

Configurar PostgreSQL en application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=postgres
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Ejecutar la aplicación desde:

ChallengueApplication.java
📌 Ejemplo de uso

Buscar libro:

1
Don Quijote

Resultado:

Libro guardado en la base de datos

Listar libros:

2
Libro{titulo='Don Quijote', idioma='es', descargas=13446, autor=Cervantes}
🎯 Objetivo del proyecto

Aplicar conceptos de:

Consumo de APIs

Manipulación de JSON

Persistencia de datos

Spring Boot

Programación orientada a objetos

Uso de bases de datos relacionales

👨‍💻 Autor

Proyecto desarrollado por:
Grecia Sanchez

[Tu Nombre]

Como parte del programa Oracle Next Education + Alura Latam.
