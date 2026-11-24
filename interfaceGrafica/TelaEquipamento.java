package interfaceGrafica;

import javax.swing.*;
import java.awt.*;

import gerenciador.GerenciadorEquipamentos;
import modelo.Equipamento;
import modelo.EquipamentoSom;
import modelo.EquipamentoProjecao;
import modelo.EquipamentoIluminacao;


public class TelaEquipamento {
    GerenciadorEquipamentos gerenciador;
    JFrame janela = new JFrame ("Tela de Equipamentos");
    JLabel label = new JLabel ("Código do Equipamento:");
    JTextField campoCodigo = new JTextField(10);
    JLabel label2 = new JLabel ("Descrição do Equipamento:");
    JTextField campoDescricao = new JTextField(30);
    JLabel label3 = new JLabel ("Valor da Diária:");
    JTextField campoValorDiaria = new JTextField(5);
    JLabel label4 = new JLabel ("Tipo de Equipamento:");
    JComboBox<String> eTipo = new JComboBox<String>(new String[] {"Som", "Iluminação", "Projeção"});
    JLabel lbeS1 = new JLabel("Potência do som:");
    JTextField campoPotencia = new JTextField(5);
    JLabel lbeS2 = new JLabel("Quantidade de canais:");
    JTextField campoCanais = new JTextField(5);
    CardLayout cardLayout = new CardLayout();

    JLabel lbeI1 = new JLabel("tipo da iluminação:");
    JTextField campoTipoI = new JTextField(20);
    JLabel lbeI2 = new JLabel("Potência da iluminação:");
    JTextField campoPotenciaI = new JTextField(5);

    JLabel lbeP1 = new JLabel("Resolução:");
    JTextField campoResolucao = new JTextField(20);
    JLabel lbeP2 = new JLabel("Luminosidade:");
    JTextField campoLuminosidade = new JTextField(5);

    JPanel painelSom = new JPanel();
    JPanel painelIluminacao = new JPanel();
    JPanel painelProjecao = new JPanel();

    JPanel painelCampos = new JPanel();
    JPanel painelEspecificos = new JPanel();
    JPanel painelbotao = new JPanel();

    JButton cadastrar = new JButton("Cadastrar");
    JButton limpar = new JButton("Limpar");


    public TelaEquipamento(GerenciadorEquipamentos gerenciador){
        this.gerenciador = gerenciador;
        janela.setSize(800,200);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        painelCampos.setLayout(new GridLayout(4,2));
        painelCampos.add(label); 
        painelCampos.add(campoCodigo);
        painelCampos.add(label2);
        painelCampos.add(campoDescricao);
        painelCampos.add(label3);
        painelCampos.add(campoValorDiaria);
        painelCampos.add(label4);
        painelCampos.add(eTipo);    
        janela.getContentPane().add(painelCampos, BorderLayout.NORTH);

        painelEspecificos.setLayout(cardLayout);
        painelSom.add(lbeS1);    
        painelSom.add(campoPotencia);
        painelSom.add(lbeS2);
        painelSom.add(campoCanais);

        painelIluminacao.add(lbeI1);
        painelIluminacao.add(campoTipoI);
        painelIluminacao.add(lbeI2);
        painelIluminacao.add(campoPotenciaI);
        
        painelProjecao.add(lbeP1);
        painelProjecao.add(campoResolucao);
        painelProjecao.add(lbeP2);
        painelProjecao.add(campoLuminosidade);
        
        painelEspecificos.add(painelSom, "Som");
        painelEspecificos.add(painelIluminacao, "Iluminação");
        painelEspecificos.add(painelProjecao, "Projeção");
        janela.getContentPane().add(painelEspecificos, BorderLayout.CENTER);

        painelbotao.add(cadastrar);
        painelbotao.add(limpar);
        janela.getContentPane().add(painelbotao, BorderLayout.SOUTH);

        cadastrar.addActionListener(e -> {
            String codigo = campoCodigo.getText();
            String descricao = campoDescricao.getText();
            String valorDiaria = campoValorDiaria.getText();
            String tipo = (String) eTipo.getSelectedItem();
            try{
            Equipamento equipamento = null;
            if (tipo.equals("Som")) {
               equipamento = new EquipamentoSom(Integer.parseInt(codigo), descricao, Double.parseDouble(valorDiaria), Integer.parseInt(campoPotencia.getText()), Integer.parseInt(campoCanais.getText()));
            } else if (tipo.equals("Iluminação")) {
                equipamento = new EquipamentoIluminacao(Integer.parseInt(codigo), descricao, Double.parseDouble(valorDiaria), campoTipoI.getText(), Double.parseDouble(campoPotenciaI.getText()));
            } else if (tipo.equals("Projeção")) {
                equipamento = new EquipamentoProjecao(Integer.parseInt(codigo), descricao, Double.parseDouble(valorDiaria), campoResolucao.getText(), Double.parseDouble(campoLuminosidade.getText()));

            }
            gerenciador.cadastrar(equipamento);
            JOptionPane.showMessageDialog(janela, "Equipamento cadastrado com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "Erro: Por favor, insira valores numéricos válidos");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(janela, "Erro: " + ex.getMessage());
            }
        });

        limpar.addActionListener(e -> {
            campoCodigo.setText("");
            campoDescricao.setText("");
            campoValorDiaria.setText("");
            campoPotencia.setText("");
            campoCanais.setText("");
            campoTipoI.setText("");
            campoPotenciaI.setText("");
            campoResolucao.setText("");
            campoLuminosidade.setText("");
        });

       eTipo.addActionListener(e -> {
    String tipo = (String) eTipo.getSelectedItem();
    cardLayout.show(painelEspecificos, tipo);
}); 
        janela.setVisible(true);
    }}
