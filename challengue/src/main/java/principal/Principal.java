package com.aluradesafio.challengue.principal;

import com.aluradesafio.challengue.dto.*;
import com.aluradesafio.challengue.model.Autor;
import com.aluradesafio.challengue.model.Libro;
import com.aluradesafio.challengue.repository.AutorRepository;
import com.aluradesafio.challengue.repository.LibroRepository;
import com.aluradesafio.challengue.service.ConsumoAPI;
import com.aluradesafio.challengue.service.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    private AutorRepository autorRepository;
    private LibroRepository libroRepository;

    private final String URL_BASE = "https://gutendex.com/books/?search=";

    public Principal(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    public void muestraMenu(){

        var opcion = -1;

        while(opcion != 0){

            System.out.println("""
                    
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    
                    """);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){

                case 1:
                    buscarLibro();
                    break;

                case 2:
                    listarLibros();
                    break;

                case 3:
                    listarAutores();
                    break;

                case 4:
                    autoresVivosPorAno();
                    break;

                case 5:
                    librosPorIdioma();
                    break;

                case 0:
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibro(){

        System.out.println("Ingrese el nombre del libro:");
        String titulo = teclado.nextLine();

        String json = consumo.obtenerDatos(URL_BASE + titulo.replace(" ","%20"));

        DatosResultado datos = conversor.obtenerDatos(json, DatosResultado.class);

        if(datos.results().size() > 0){

            DatosLibro datosLibro = datos.results().get(0);
            DatosAutor datosAutor = datosLibro.authors().get(0);

            Optional<Autor> autorExistente = autorRepository.findByNombre(datosAutor.name());

            Autor autor;

            if(autorExistente.isPresent()){
                autor = autorExistente.get();
            }else{
                autor = new Autor(datosAutor);
                autorRepository.save(autor);
            }

            Optional<Libro> libroExistente = libroRepository.findByTitulo(datosLibro.title());

            if(libroExistente.isPresent()){
                System.out.println("El libro ya está registrado");
            }else{
                Libro libro = new Libro(datosLibro, autor);
                libroRepository.save(libro);
                System.out.println("Libro guardado en la base de datos");
            }

        }else{
            System.out.println("Libro no encontrado");
        }
    }

    private void listarLibros(){

        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);

    }

    private void listarAutores(){

        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);

    }

    private void autoresVivosPorAno(){

        System.out.println("Ingrese el año:");
        Integer ano = teclado.nextInt();
        teclado.nextLine();

        List<Autor> autores = autorRepository.autoresVivosEnAno(ano);
        autores.forEach(System.out::println);

    }

    private void librosPorIdioma(){

        System.out.println("""
                Ingrese el idioma:
                es - Español
                en - Inglés
                fr - Francés
                pt - Portugués
                """);

        String idioma = teclado.nextLine();

        List<Libro> libros = libroRepository.findByIdioma(idioma);
        libros.forEach(System.out::println);

    }

}