package com.aluradesafio.challengue.model;

import com.aluradesafio.challengue.dto.DatosLibro;
import jakarta.persistence.*;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;
    private Integer descargas;

    @ManyToOne
    private Autor autor;

    public Libro(){}

    public Libro(DatosLibro datosLibro, Autor autor){
        this.titulo = datosLibro.title();
        this.idioma = datosLibro.languages().get(0);
        this.descargas = datosLibro.download_count();
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", descargas=" + descargas +
                ", autor=" + autor.getNombre() +
                '}';
    }
}