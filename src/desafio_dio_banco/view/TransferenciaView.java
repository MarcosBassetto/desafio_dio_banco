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

public class TransferenciaView {

	public TransferenciaView(Banco banco) {
		JFrame frmTransferencia = new JFrame("Operação de Transferencia");
		frmTransferencia.setLayout(null);
		frmTransferencia.setSize(400, 240);
		frmTransferencia.setResizable(false);

		JLabel lblOrigem = new JLabel("Selecione o Banco Origem:");
		lblOrigem.setBounds(10, 10, 180, 30);

		JTextField txtOrigem = new JTextField();
		txtOrigem.setBounds(200, 12, 180, 30);

		JLabel lblDestino = new JLabel(("Selecione o Banco Destino:"));
		lblDestino.setBounds(10, 50, 200, 30);

		JTextField txtDestino = new JTextField();
		txtDestino.setBounds(200, 52, 180, 30);

		JLabel lblValor = new JLabel(("Informe o valor:"));
		lblValor.setBounds(50, 90, 200, 30);

		JTextField txtValor = new JTextField();
		txtValor.setBounds(140, 90, 180, 30);

		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.setBounds(100, 140, 200, 30);

		frmTransferencia.add(lblOrigem);
		frmTransferencia.add(lblDestino);
		frmTransferencia.add(txtOrigem);
		frmTransferencia.add(txtDestino);
		frmTransferencia.add(lblValor);
		frmTransferencia.add(txtValor);
		frmTransferencia.add(btnTransferir);

		frmTransferencia.setVisible(true);

		btnTransferir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Conta> contas = banco.getContas();
				Conta destino = null;
				Conta origem = null;
				for (int i = 0; i < contas.size(); i++) {
					if (txtDestino.getText().equalsIgnoreCase(String.valueOf(contas.get(i).getNumero()))) {
						destino = contas.get(i);
					}
					if (txtOrigem.getText().equalsIgnoreCase(String.valueOf(contas.get(i).getNumero()))) {
						origem = contas.get(i);
					}
				}
				if (!(destino == null || origem == null || origem == destino)) {
					double valor = Double.valueOf(txtValor.getText());
					if (origem.getSaldo() > valor) {
						origem.transferir(Double.valueOf(txtValor.getText()), destino);
						JOptionPane.showMessageDialog(frmTransferencia,
								"Transferencia efetuada da Conta " + origem.getNumero() 
								+ " para a conta "
								+ destino.getNumero());
					}else {
						JOptionPane.showMessageDialog(frmTransferencia, "Conta Invalida", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				} 
			}
		});
	}
}
