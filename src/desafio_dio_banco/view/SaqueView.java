package desafio_dio_banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import desafio_dio_banco.Banco;
import desafio_dio_banco.Conta;

public class SaqueView {
	
	
	public SaqueView(Banco banco) {
		
		JFrame frmSaque = new JFrame("Operação de Saque");
		frmSaque.setLayout(null);
		frmSaque.setSize(400, 180);
		frmSaque.setResizable(false);
		
		JLabel lblValor = new JLabel(("Selecione o valor"));
		lblValor.setBounds(10, 10, 200, 30);
		
		JLabel lblBanco = new JLabel(("Selecione o Banco:"));
		lblBanco.setBounds(10, 50, 200, 30);
		
		JTextField txtValor = new JTextField();
		txtValor.setBounds(200, 12, 180, 30);
		
		JTextField txtBanco = new JTextField();
		txtBanco.setBounds(200, 52, 180, 30);
		
		JButton btnSaque =  new JButton("Sacar");
		btnSaque.setBounds(100, 100, 200, 30);

		frmSaque.add(lblValor);
		frmSaque.add(lblBanco);
		frmSaque.add(txtValor);
		frmSaque.add(txtBanco);
		frmSaque.add(btnSaque);
		frmSaque.setVisible(true);
		
		btnSaque.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Conta> contas = banco.getContas();
				double valor = 0;
				Conta conta = null;
				for (int i = 0; i < contas.size(); i++) {
					if (txtBanco.getText().equalsIgnoreCase(String.valueOf(contas.get(i).getNumero()))) {
						valor = Double.valueOf(txtValor.getText());
						conta = contas.get(i);
					}
				}
				
				if (conta != null && conta.getSaldo() >= valor) {
					conta.sacar(valor);
					JOptionPane.showMessageDialog(frmSaque, "Saque realizado com Sucesso.");
				} else {
					JOptionPane.showMessageDialog(frmSaque, "Saque não realizado - Verifique os dados.", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
	}
}
