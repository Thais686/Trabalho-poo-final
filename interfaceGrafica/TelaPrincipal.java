package interfaceGrafica;

import gerenciador.GerenciadorCliente;
import javax.swing.*;
import java.awt.*;
import gerenciador.GerenciadorEquipamentos;
import gerenciador.GerenciadorLocacao;

public class TelaPrincipal {

    JFrame janela = new JFrame("Sistema de Locação");

    JButton botaoCliente = new JButton("Clientes");
    JButton botaoEquipamento = new JButton("Equipamentos");
    JButton botaoLocacao = new JButton("Locações");
    JButton botaoConsulta = new JButton("Consultas");
    GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
    GerenciadorEquipamentos gerenciadorEquipamentos = new GerenciadorEquipamentos();
    GerenciadorLocacao gerenciadorLocacao = new GerenciadorLocacao();

    public TelaPrincipal() {

        janela.setSize(500, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new GridLayout(2, 2, 10, 10));

        janela.add(botaoCliente);
        janela.add(botaoEquipamento);
        janela.add(botaoLocacao);
        janela.add(botaoConsulta);
       
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);

         botaoCliente.addActionListener(e -> new TelaCliente(gerenciadorCliente));
         botaoLocacao.addActionListener(e -> new TelaLocacao(gerenciadorCliente, gerenciadorEquipamentos, gerenciadorLocacao));
         botaoConsulta.addActionListener(e -> new TelaConsulta(gerenciadorCliente, gerenciadorEquipamentos, gerenciadorLocacao));
         botaoEquipamento.addActionListener(e -> new TelaEquipamento(gerenciadorEquipamentos));
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
