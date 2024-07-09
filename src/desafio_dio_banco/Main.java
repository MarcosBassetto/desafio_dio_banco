package desafio_dio_banco;

import desafio_dio_banco.view.BancoView;

public class Main {

	public static void main(String[] args) {
		
		Banco banco = new Banco();
		banco.setNome("MeuBanco");
		
		BancoView bancoView = new BancoView(banco);
		

		/*
		Cliente cliente = new Cliente();
		cliente.setNome("Marcos");
		
		Conta cc = new ContaCorrente(cliente);
		Conta cp = new ContaPoupanca(cliente);
		
		cc.deositar(100);
		cc.transferir(25, cp);
		
		cc.imprimirExtrato();
		cp.imprimirExtrato();
*/
	}

}
