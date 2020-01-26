package com.cteste.cursomc2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cteste.cursomc2.domain.Pedido;
import com.cteste.cursomc2.repositories.PedidoRepository;
import com.cteste.cursomc2.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado"+id+"Tipo"+Pedido.class.getName());
			
		}
		return obj.orElse(null);
		}

}
