package com.aluradesafio.challengue;

import com.aluradesafio.challengue.principal.Principal;
import com.aluradesafio.challengue.repository.AutorRepository;
import com.aluradesafio.challengue.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengueApplication implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    public static void main(String[] args) {
        SpringApplication.run(ChallengueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal(autorRepository, libroRepository);
        principal.muestraMenu();

    }
}