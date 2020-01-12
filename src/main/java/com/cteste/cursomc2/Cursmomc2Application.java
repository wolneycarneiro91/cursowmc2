package com.cteste.cursomc2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cteste.cursomc2.domain.Categoria;
import com.cteste.cursomc2.domain.Cidade;
import com.cteste.cursomc2.domain.Cliente;
import com.cteste.cursomc2.domain.Endereco;
import com.cteste.cursomc2.domain.Estado;
import com.cteste.cursomc2.domain.Produto;
import com.cteste.cursomc2.domain.enums.TipoCliente;
import com.cteste.cursomc2.repositories.CategoriaRepository;
import com.cteste.cursomc2.repositories.CidadeRepository;
import com.cteste.cursomc2.repositories.ClienteRepository;
import com.cteste.cursomc2.repositories.EnderecoRepository;
import com.cteste.cursomc2.repositories.EstadoRepository;
import com.cteste.cursomc2.repositories.ProdutoRepository;

@SpringBootApplication
public class Cursmomc2Application implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;	
	
	@Autowired
	private CidadeRepository cidadeRepository;	
	
	@Autowired
	private ClienteRepository clienteRepository;	
	
	@Autowired
	private EnderecoRepository enderecoRepository;		
	
	
	public static void main(String[] args) {
		SpringApplication.run(Cursmomc2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria (null,"Informática");
		Categoria cat2 = new Categoria (null,"Escritório");
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		//Associações na tabela associativa CATEGORIA_PRODUTO
		cat1.getProdutos().addAll(Arrays.asList(p1, p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
			
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2,p3));
		//Estados e CIdades		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		Cidade c1 = new Cidade(null,"Uberlândia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		//CLientes e Endereços
		Cliente cli1 = new Cliente(null,"Maria SIlva","maria@teste.com","71999999999",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("71988888888","71977777777"));		
		Endereco e1 = new Endereco(null,"Rua Flores","300","Apto 303","Jardim","38220834",cli1,c1);
		Endereco e2 = new Endereco(null,"Avenida Matos","105","Sala 800","Centro","38777012",cli1,c2);		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
	}

}



