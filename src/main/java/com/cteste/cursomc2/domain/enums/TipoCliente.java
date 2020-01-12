package com.cteste.cursomc2.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2,"Pssoa Jurídica");
	
	private int cod;
	private String descricao;
	private TipoCliente(int cod, String descricao) {
		
		this.cod = cod;
		this.descricao = descricao;
		
	}
	
	private int getCod() {		
		return cod;
	}
	private String getDescricao() {		
		return descricao;
	}	
	
	public static TipoCliente toEnum(Integer cod) {
		
		if(cod==null) {
			return null;			
		}
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {				
				return x;
			}
			
		}
		throw new 
		IllegalArgumentException("ID inválido -"+cod);
	}
}
