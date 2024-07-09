package desafio_dio_banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import desafio_dio_banco.Banco;
import desafio_dio_banco.Conta;

public class ContaViewer extends JFrame {

    private JTextArea textArea;
    private JScrollPane scrollPane;

    private Banco banco;

    public ContaViewer(Banco banco) {
        this.banco = banco;

        setTitle("Informações da Conta");
        setLayout(null);
        setSize(450, 400);
        setResizable(false);

        JButton btnImprimir = new JButton("Imprimir Informações");
        btnImprimir.setBounds(10, 10, 400, 25);
        add(btnImprimir);

        textArea = new JTextArea();
        textArea.setEditable(false);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 50, 400, 300);
        add(scrollPane);

        btnImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirInformacoes();
            }
        });

        setVisible(true);
    }

    private void imprimirInformacoes() {
        textArea.setText("RELATÓRIO DE CONTAS\n\n");
      
        List<Conta> contas = banco.getContas();
        
        for (Conta conta : contas) {
            textArea.append("Informações da Conta:\n");
            textArea.append(String.format("Titular: %s \n", conta.getCliente().getNome()));
            textArea.append(String.format("Agência: %d \n", conta.getAgencia()));
            textArea.append(String.format("Número: %d \n", conta.getNumero()));
            textArea.append(String.format("Saldo: %.2f \n", conta.getSaldo()));
            textArea.append("-------------------------\n");
        }
    }
}