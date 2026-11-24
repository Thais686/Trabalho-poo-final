
package interfaceGrafica;

import javax.swing.*;
import java.awt.*;

import modelo.Cliente;
import modelo.Equipamento;
import modelo.Locacao;

import gerenciador.GerenciadorCliente;
import gerenciador.GerenciadorEquipamentos;
import gerenciador.GerenciadorLocacao;

import excecoes.ClienteNaoEncontradoException;
import excecoes.EquipamentoNaoEncontradoException;
import excecoes.EquipamentoJaAlugadoException;
import excecoes.EquipamentoJaEstaNaSuaLocacaoException;

public class TelaLocacao {

    JFrame janela = new JFrame("Cadastro de Locação");

    JLabel textoCliente = new JLabel("ID do cliente:");
    JLabel textoDias = new JLabel("Quantidade de dias:");
    JLabel textoEquipamento = new JLabel("Código do equipamento:");

    JTextField campoCliente = new JTextField();
    JTextField campoDias = new JTextField();
    JTextField campoEquipamento = new JTextField();

    JButton botaoAdicionar = new JButton("Adicionar equipamento");
    JButton botaoRegistrar = new JButton("Registrar locação");

    GerenciadorCliente gerenciadorCliente;
    GerenciadorEquipamentos gerenciadorEquipamentos;
    GerenciadorLocacao gerenciadorLocacao;

    Locacao locacao;

    public TelaLocacao(GerenciadorCliente gc,
                       GerenciadorEquipamentos ge,
                       GerenciadorLocacao gl) {

        gerenciadorCliente = gc;
        gerenciadorEquipamentos = ge;
        gerenciadorLocacao = gl;

        janela.setSize(450, 300);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLayout(new GridLayout(4, 2, 10, 10));

        janela.add(textoCliente);
        janela.add(campoCliente);

        janela.add(textoDias);
        janela.add(campoDias);

        janela.add(textoEquipamento);
        janela.add(campoEquipamento);

        janela.add(botaoAdicionar);
        janela.add(botaoRegistrar);

        botaoAdicionar.addActionListener(e -> adicionarEquipamento());
        botaoRegistrar.addActionListener(e -> registrarLocacao());

        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    public void adicionarEquipamento() {
        try {
            int idCliente = Integer.parseInt(campoCliente.getText());
            int dias = Integer.parseInt(campoDias.getText());
            int codigo = Integer.parseInt(campoEquipamento.getText());

            if (locacao == null) {
                Cliente cliente = gerenciadorCliente.buscarPorId(idCliente);

                locacao = new Locacao(cliente, dias);

                campoCliente.setEditable(false);
                campoDias.setEditable(false);
            }

            Equipamento equipamento = gerenciadorEquipamentos.buscarPorCodigo(codigo);

            locacao.adicionarEquipamento(equipamento);

            campoEquipamento.setText("");

            JOptionPane.showMessageDialog(janela, "Equipamento adicionado!");

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(janela, "Informe números válidos!");

        } catch (ClienteNaoEncontradoException | EquipamentoNaoEncontradoException |
                 EquipamentoJaAlugadoException | EquipamentoJaEstaNaSuaLocacaoException erro) {

            JOptionPane.showMessageDialog(janela, erro.getMessage());

        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(janela, erro.getMessage());
        }
    }

    public void registrarLocacao() {
        try {
            if (locacao == null) {
                throw new IllegalArgumentException("Adicione pelo menos um equipamento!");
            }

            gerenciadorLocacao.cadastrar(locacao);

            JOptionPane.showMessageDialog(janela, "Locação registrada com sucesso!");

            locacao = null;

            campoCliente.setText("");
            campoDias.setText("");
            campoEquipamento.setText("");

            campoCliente.setEditable(true);
            campoDias.setEditable(true);

        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(janela, erro.getMessage());
        }
    }
}