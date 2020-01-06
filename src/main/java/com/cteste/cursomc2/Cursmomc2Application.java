package com.cteste.cursomc2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cteste.cursomc2.domain.Categoria;
import com.cteste.cursomc2.repositories.CategoriaRepository;

@SpringBootApplication
public class Cursmomc2Application implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(Cursmomc2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria (null,"Informática");
		Categoria cat2 = new Categoria (null,"Escritório");
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		
	}

}

