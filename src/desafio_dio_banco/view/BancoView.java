package desafio_dio_banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import desafio_dio_banco.Banco;

	

public class BancoView {
	
	public Banco banco;

	public BancoView(Banco banco) {
		
		this.banco = banco;
		
		JFrame frmBanco = new JFrame("Meu Banco");
		frmBanco.setLayout(null);
		frmBanco.setSize(500, 300);
		frmBanco.setResizable(false);
		
		JLabel lblOperacao = new JLabel(("Escolha a Operação Desejada").toUpperCase());
		lblOperacao.setBounds(100, 10, 200, 30);
		
		JButton btnConta = new JButton("Nova Conta");
		btnConta.setBounds(25, 50, 120, 60);
		
		JButton btnDeposito = new JButton("Deposito");
		btnDeposito.setBounds(180, 50, 120, 60);
		
		JButton btnSaque = new JButton("Saque");
		btnSaque.setBounds(330, 50, 120, 60);


		JButton btnTransferencia = new JButton("Transferência");
		btnTransferencia.setBounds(80, 160, 120, 60);

		JButton btnImprime = new JButton("Imprime Dados");
		btnImprime.setBounds(280, 160, 120, 60);
		
		frmBanco.add(btnDeposito);
		frmBanco.add(btnSaque);
		frmBanco.add(btnTransferencia);
		frmBanco.add(btnConta);
		frmBanco.add(lblOperacao);
		frmBanco.add(btnImprime);

		frmBanco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBanco.setVisible(true);

		btnDeposito.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DepositoVeiw(banco);
			}
		});
		
		btnTransferencia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TransferenciaView(banco);
			}
		});;
	
		btnSaque.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SaqueView(banco);
			}
		});
		
		btnConta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ClienteViwer(banco);
				
			}
		});
		
		btnImprime.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ContaViewer(banco);
			}
		});
		
	}
	   
}
