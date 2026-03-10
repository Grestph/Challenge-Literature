package com.aluradesafio.challengue.model;

import com.aluradesafio.challengue.dto.DatosAutor;
import jakarta.persistence.*;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer nacimiento;
    private Integer fallecimiento;

    public Autor(){}

    public Autor(DatosAutor datosAutor){
        this.nombre = datosAutor.name();
        this.nacimiento = datosAutor.birth_year();
        this.fallecimiento = datosAutor.death_year();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public Integer getFallecimiento() {
        return fallecimiento;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", nacimiento=" + nacimiento +
                ", fallecimiento=" + fallecimiento +
                '}';
    }
}