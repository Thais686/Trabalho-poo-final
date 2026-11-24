
package interfaceGrafica;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Locacao;

import gerenciador.GerenciadorCliente;
import gerenciador.GerenciadorEquipamentos;
import gerenciador.GerenciadorLocacao;

import excecoes.ClienteNaoEncontradoException;
import excecoes.EquipamentoNaoEncontradoException;

public class TelaConsulta {

    JFrame janela = new JFrame("Consultas");

    JLabel textoCliente = new JLabel("ID do cliente:");
    JLabel textoEquipamento = new JLabel("Código do equipamento:");
    JLabel textoLocacao = new JLabel("Número da locação:");

    JTextField campoCliente = new JTextField();
    JTextField campoEquipamento = new JTextField();
    JTextField campoLocacao = new JTextField();

    JButton botaoListarClientes = new JButton("Listar clientes");
    JButton botaoConsultarCliente = new JButton("Consultar cliente");

    JButton botaoListarEquipamentos = new JButton("Listar equipamentos");
    JButton botaoConsultarEquipamento = new JButton("Consultar equipamento");
    JButton botaoDisponiveis = new JButton("Equipamentos disponíveis");

    JButton botaoHistorico = new JButton("Histórico de locações");
    JButton botaoAtivas = new JButton("Locações ativas");
    JButton botaoHistoricoCliente = new JButton("Histórico do cliente");
    JButton botaoDetalhes = new JButton("Detalhes da locação");

    JTextArea areaResultado = new JTextArea();
    JScrollPane rolagem = new JScrollPane(areaResultado);

    GerenciadorCliente gerenciadorCliente;
    GerenciadorEquipamentos gerenciadorEquipamentos;
    GerenciadorLocacao gerenciadorLocacao;

    public TelaConsulta(GerenciadorCliente gc,
                        GerenciadorEquipamentos ge,
                        GerenciadorLocacao gl) {

        gerenciadorCliente = gc;
        gerenciadorEquipamentos = ge;
        gerenciadorLocacao = gl;

        janela.setSize(750, 550);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLayout(new BorderLayout(10, 10));

        JPanel painelCampos = new JPanel(new GridLayout(3, 2, 5, 5));

        painelCampos.add(textoCliente);
        painelCampos.add(campoCliente);

        painelCampos.add(textoEquipamento);
        painelCampos.add(campoEquipamento);

        painelCampos.add(textoLocacao);
        painelCampos.add(campoLocacao);

        JPanel painelBotoes = new JPanel(new GridLayout(3, 3, 5, 5));

        painelBotoes.add(botaoListarClientes);
        painelBotoes.add(botaoConsultarCliente);
        painelBotoes.add(botaoListarEquipamentos);
        painelBotoes.add(botaoConsultarEquipamento);
        painelBotoes.add(botaoDisponiveis);
        painelBotoes.add(botaoHistorico);
        painelBotoes.add(botaoAtivas);
        painelBotoes.add(botaoHistoricoCliente);
        painelBotoes.add(botaoDetalhes);

        JPanel painelSuperior = new JPanel(new BorderLayout(5, 5));

        painelSuperior.add(painelCampos, BorderLayout.NORTH);
        painelSuperior.add(painelBotoes, BorderLayout.CENTER);

        areaResultado.setEditable(false);

        janela.add(painelSuperior, BorderLayout.NORTH);
        janela.add(rolagem, BorderLayout.CENTER);

        // Ações dos botões

        botaoListarClientes.addActionListener(e -> listarClientes());
        botaoConsultarCliente.addActionListener(e -> consultarCliente());

        botaoListarEquipamentos.addActionListener(e -> listarEquipamentos());
        botaoConsultarEquipamento.addActionListener(e -> consultarEquipamento());
        botaoDisponiveis.addActionListener(e -> listarDisponiveis());

        botaoHistorico.addActionListener(e -> mostrarHistorico());
        botaoAtivas.addActionListener(e -> listarAtivas());
        botaoHistoricoCliente.addActionListener(e -> consultarHistoricoCliente());
        botaoDetalhes.addActionListener(e -> exibirDetalhes());

        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    // CONSULTAS DE CLIENTES

    public void listarClientes() {
        exibirResultado(gerenciadorCliente.listar());
    }

    public void consultarCliente() {

        try {
            int id = Integer.parseInt(campoCliente.getText());

            exibirResultado(gerenciadorCliente.consultar(id));

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(janela, "Informe um ID válido!");

        } catch (ClienteNaoEncontradoException erro) {
            JOptionPane.showMessageDialog(janela, erro.getMessage());
        }
    }

    // CONSULTAS DE EQUIPAMENTOS

    public void listarEquipamentos() {
        exibirResultado(gerenciadorEquipamentos.listar());
    }

    public void consultarEquipamento() {

        try {
            int codigo = Integer.parseInt(campoEquipamento.getText());

            exibirResultado(gerenciadorEquipamentos.consultar(codigo));

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(janela, "Informe um código válido!");

        } catch (EquipamentoNaoEncontradoException erro) {
            JOptionPane.showMessageDialog(janela, erro.getMessage());
        }
    }

    public void listarDisponiveis() {
        exibirResultado(gerenciadorEquipamentos.listarDisponiveis());
    }

    // CONSULTAS DE LOCAÇÕES

    public void mostrarHistorico() {
        exibirResultado(gerenciadorLocacao.mostrarHistorico());
    }

    public void listarAtivas() {
        exibirResultado(gerenciadorLocacao.listarLocacoesAtivas());
    }

    public void consultarHistoricoCliente() {

        try {
            int id = Integer.parseInt(campoCliente.getText());

            Cliente cliente = gerenciadorCliente.buscarPorId(id);

            exibirResultado(gerenciadorLocacao.consultarHistorico(cliente));

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(janela, "Informe um ID válido!");

        } catch (ClienteNaoEncontradoException erro) {
            JOptionPane.showMessageDialog(janela, erro.getMessage());
        }
    }

    public void exibirDetalhes() {

    try {
        int numero = Integer.parseInt(campoLocacao.getText());

        ArrayList<Locacao> locacoes = gerenciadorLocacao.getLocacoes();

        if (numero <= 0 || numero > locacoes.size()) {
            throw new IllegalArgumentException("Número de locação inválido!");
        }

        Locacao locacao = locacoes.get(numero - 1);

        exibirResultado(gerenciadorLocacao.exibirDetalhes(locacao));

    } catch (NumberFormatException erro) {
        JOptionPane.showMessageDialog(janela, "Informe um número válido!");

    } catch (IllegalArgumentException erro) {
        JOptionPane.showMessageDialog(janela, erro.getMessage());
    }
}



    public void exibirResultado(String resultado) {

        if (resultado.isEmpty()) {
            areaResultado.setText("Nenhum resultado encontrado!");
        } else {
            areaResultado.setText(resultado);
        }
    }
}
