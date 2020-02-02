package com.cteste.cursomc2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cteste.cursomc2.domain.Categoria;
import com.cteste.cursomc2.repositories.CategoriaRepository;
import com.cteste.cursomc2.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado"+id+"Tipo"+Categoria.class.getName());
			
		}
		return obj.orElse(null);
		}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {	
		find(obj.getId());
		return repo.save(obj);
	}	

}
