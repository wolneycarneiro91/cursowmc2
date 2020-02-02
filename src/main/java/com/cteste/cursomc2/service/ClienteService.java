package com.cteste.cursomc2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cteste.cursomc2.domain.Cliente;
import com.cteste.cursomc2.repositories.ClienteRepository;
import com.cteste.cursomc2.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado"+id+"Tipo"+Cliente.class.getName());
			
		}
		return obj.orElse(null);
		}

}
