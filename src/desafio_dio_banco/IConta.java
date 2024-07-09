package desafio_dio_banco;

public interface IConta {
	
	
	
	void depositar(double valor) ;
	
	void sacar(double valor) ;
	
	void transferir(double valor, Conta contaDestino) ;
	
	void imprimirExtrato();

}
