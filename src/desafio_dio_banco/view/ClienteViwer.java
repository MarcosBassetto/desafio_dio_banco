package desafio_dio_banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import desafio_dio_banco.Banco;
import desafio_dio_banco.Cliente;
import desafio_dio_banco.Conta;
import desafio_dio_banco.ContaCorrente;
import desafio_dio_banco.ContaPoupanca;

public class ClienteViwer {
	
	public ClienteViwer(Banco banco) {
		
		JFrame frmCliente = new JFrame("Cadastro de cliente");
		frmCliente.setLayout(null);
		frmCliente.setSize(400, 220);
		frmCliente.setResizable(false);
		
		JLabel lblNome = new JLabel("Nome Do Cliente:");
		lblNome.setBounds(10, 10, 180, 30);

		JTextField txtNome = new JTextField();
		txtNome.setBounds(200, 12, 180, 30);
		
		JRadioButton rbContaCorrente = new JRadioButton("Conta Corrente");
		rbContaCorrente.setBounds(10, 50, 150, 30);
		rbContaCorrente.setSelected(true);

		JRadioButton rbContaPoupanca = new JRadioButton("Conta Poupança");
		rbContaPoupanca.setBounds(200, 50, 150, 30);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbContaCorrente);
		group.add(rbContaPoupanca);

		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(100, 100, 200, 30);

		frmCliente.add(lblNome);
		frmCliente.add(txtNome);
		frmCliente.add(rbContaCorrente);
		frmCliente.add(rbContaPoupanca);
		frmCliente.add(btnCadastrar);

		
		frmCliente.setVisible(true);
		
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtNome.getText().isBlank()) {
                    Cliente cliente = new Cliente(txtNome.getText());
                    Conta conta;
                    if (rbContaCorrente.isSelected()) {
                        conta = new ContaCorrente(cliente);
                    } else {
                        conta = new ContaPoupanca(cliente);
                    }
                    List<Conta> clientes = banco.getContas();
                    clientes.add(conta);
                    banco.setContas(clientes);
                    
                    txtNome.setText("");

                    JOptionPane.showMessageDialog(frmCliente, "Cliente cadastrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frmCliente, "Por favor, insira o nome do cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
		
	}

}
