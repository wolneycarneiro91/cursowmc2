package com.cteste.cursomc2.domain.enums;

public enum EstadoPagamento {	
	PEDENTE(1,"PEDENTE"),
	QUITADO(2,"QUITADO"),
	CANCELADO(3,"CANCELADO") ;
	
	private int cod;
	private String descricao;
	private EstadoPagamento(int cod, String descricao) {
		
		this.cod = cod;
		this.descricao = descricao;
		
	}
	
	public int getCod() {		
		return cod;
	}
	private String getDescricao() {		
		return descricao;
	}	
	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if(cod==null) {
			return null;			
		}
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {				
				return x;
			}
			
		}
		throw new 
		IllegalArgumentException("ID inválido -"+cod);
	}
}
