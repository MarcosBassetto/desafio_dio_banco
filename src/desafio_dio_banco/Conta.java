package desafio_dio_banco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Conta implements IConta {
	
	private final static int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliete) {
		agencia = AGENCIA_PADRAO;
		numero = SEQUENCIAL++;
		this.cliente = cliete;
	}




	@Override
	public void depositar(double valor) {
		this.saldo+=valor;
	}


	@Override
	public void sacar(double valor) {
		this.saldo-=valor;

	}


	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	protected void imprimeInfosComuns() {
		System.out.println(String.format("Titular: %s \nAgência: %d \nNumero: %d \nSaldo: %.2f \n",this.cliente.getNome(), this.agencia, this.numero, this.saldo));
	}
	
}
