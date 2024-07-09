package desafio_dio_banco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
	
	private String nome;

	public Cliente(String nome) {
		this.nome = nome;
	}
	
	

}
