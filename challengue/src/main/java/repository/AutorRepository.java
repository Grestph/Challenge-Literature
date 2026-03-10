package com.aluradesafio.challengue.repository;

import com.aluradesafio.challengue.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.nacimiento <= :ano AND (a.fallecimiento IS NULL OR a.fallecimiento >= :ano)")
    List<Autor> autoresVivosEnAno(Integer ano);

}