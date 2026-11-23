
package interfaceGrafica;

import javax.swing.*;
import java.awt.*;

import modelo.Cliente;
import gerenciador.GerenciadorCliente;

public class TelaCliente {

    JFrame janela = new JFrame("Cadastro de Clientes");

    JLabel textoId = new JLabel("ID:");
    JLabel textoNome = new JLabel("Nome:");
    JLabel textoTelefone = new JLabel("Telefone:");
    JLabel textoEmail = new JLabel("Email:");

    JTextField campoId = new JTextField();
    JTextField campoNome = new JTextField();
    JTextField campoTelefone = new JTextField();
    JTextField campoEmail = new JTextField();

    JButton botaoCadastrar = new JButton("Cadastrar");
    JButton botaoLimpar = new JButton("Limpar");

    GerenciadorCliente gerenciador;

    public TelaCliente(GerenciadorCliente gerenciador) {

        this.gerenciador = gerenciador;

        janela.setSize(400, 350);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLayout(new GridLayout(5, 2, 10, 10));

        janela.add(textoId);
        janela.add(campoId);

        janela.add(textoNome);
        janela.add(campoNome);

        janela.add(textoTelefone);
        janela.add(campoTelefone);

        janela.add(textoEmail);
        janela.add(campoEmail);

        janela.add(botaoCadastrar);
        janela.add(botaoLimpar);

        botaoCadastrar.addActionListener(e -> cadastrar());
        botaoLimpar.addActionListener(e -> limpar());

        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    public void cadastrar() {

        try {
            int id = Integer.parseInt(campoId.getText());

            String nome = campoNome.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();

            Cliente cliente = new Cliente(nome, telefone, email, id);

            gerenciador.cadastrar(cliente);

            JOptionPane.showMessageDialog(janela, "Cliente cadastrado com sucesso!");

            limpar();

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(janela, "Informe um ID válido!");

        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(janela, erro.getMessage());
        }
    }

    public void limpar() {
        campoId.setText("");
        campoNome.setText("");
        campoTelefone.setText("");
        campoEmail.setText("");
    }
}
