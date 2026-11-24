package gerenciador;
import java.util.ArrayList;
import modelo.Locacao;
import modelo.Cliente;
import modelo.Equipamento;

public class GerenciadorLocacao {

private ArrayList<Locacao> locacoes;


public GerenciadorLocacao(){

    locacoes= new ArrayList<Locacao>();

}

public ArrayList<Locacao> getLocacoes() {
    return locacoes;
}

public void cadastrar(Locacao l1) {

     if (l1.getEquipamentos().isEmpty()) {
        throw new IllegalArgumentException("A locação precisa ter pelo menos um equipamento!");
    }

    locacoes.add(l1);
 }

public String mostrarHistorico() {

    String resultado= "";

        for (Locacao l : locacoes) {

            resultado +="Cliente: " + l.getCliente().getNome() + "\n";
            resultado +="Quantidade de dias: " + l.getQntdDias() + "\n";

            resultado +="Equipamentos:" + "\n";

            for (Equipamento e : l.getEquipamentos()) {
               resultado += "Código: " + e.getCodigo() + " | Descrição: " + e.getDescricao() + "\n";
            }

            resultado += "Valor total: R$ " + l.calcularTotal() + "\n";
            resultado += "Finalizada: " + l.getFinalizado() + "\n";

        }

        return resultado;
    }

    public String listarLocacoesAtivas() {

        String resultado = "";

    for (Locacao l : locacoes) {

        if (!l.getFinalizado()) {
            resultado += "Cliente: " + l.getCliente().getNome() + "\n";
            resultado += "Dias: " + l.getQntdDias() + "\n";
            for (Equipamento e : l.getEquipamentos()) {
                    resultado += "Equipamento: " + e.getDescricao() + "\n";
                }
            resultado += "Valor total: R$ " + l.calcularTotal() + "\n";
        }

        
    }
    return resultado;
 }

     public String consultarHistorico(Cliente cliente) {

        String resultado = "";

        for (Locacao l : locacoes) {

            if (l.getCliente().getId() == cliente.getId()) {

                resultado += "Quantidade de dias: " + l.getQntdDias() + "\n";

                for (Equipamento e : l.getEquipamentos()) {
                    resultado += "Equipamento: " + e.getDescricao() + "\n";
                }

                resultado += "Valor total: R$ " + l.calcularTotal() + "\n";
                resultado += "Finalizada: " + l.getFinalizado() + "\n";

               
            }
        }
        return resultado;
    }

public String exibirDetalhes(Locacao l) {

    String resultado= "";

    resultado +="Cliente: " + l.getCliente().getNome() + "\n";
    resultado += "Quantidade de dias: " + l.getQntdDias() + "\n";

    resultado += "Equipamentos:\n";

    for (Equipamento e : l.getEquipamentos()) {

        resultado += "Equipamento: " + e.getCodigo() + "\n";
        resultado += "Descrição: " + e.getDescricao() + "\n";
       resultado += "Valor: R$ " + l.calcularValorEquipamento(e) + "\n";
    }

    resultado +="Valor total: R$ " + l.calcularTotal() + "\n";

    return resultado;
}
    
    
}
