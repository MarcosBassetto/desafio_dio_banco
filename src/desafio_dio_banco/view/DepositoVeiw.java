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

public class DepositoVeiw {

	public DepositoVeiw(Banco banco) {
		JFrame frmDeposito = new JFrame("Operação de Deposito");
		frmDeposito.setLayout(null);
		frmDeposito.setSize(400, 180);
		frmDeposito.setResizable(false);

		JLabel lblValor = new JLabel(("Selecione o valor"));
		lblValor.setBounds(10, 10, 200, 30);

		JLabel lblBanco = new JLabel(("Selecione o Banco Destino:"));
		lblBanco.setBounds(10, 50, 200, 30);

		JTextField txtValor = new JTextField();
		txtValor.setBounds(200, 12, 180, 30);

		JTextField txtBanco = new JTextField();
		txtBanco.setBounds(200, 52, 180, 30);

		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setBounds(100, 100, 200, 30);

		frmDeposito.add(lblValor);
		frmDeposito.add(lblBanco);
		frmDeposito.add(txtValor);
		frmDeposito.add(txtBanco);
		frmDeposito.add(btnDepositar);
		frmDeposito.setVisible(true);

		btnDepositar.addActionListener(new ActionListener() {

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
				if (conta != null) {
					conta.depositar(valor);
					JOptionPane.showMessageDialog(frmDeposito, "Deposito realizado com Sucesso.");
				} else {
					JOptionPane.showMessageDialog(frmDeposito, "Deposito não realizado - Verifique os dados.", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}

}
