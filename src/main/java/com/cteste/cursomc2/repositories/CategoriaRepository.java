package com.cteste.cursomc2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cteste.cursomc2.domain.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Integer>{

}
// teste
