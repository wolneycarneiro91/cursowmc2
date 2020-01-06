package com.cteste.cursomc2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cteste.cursomc2.domain.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer>{

}