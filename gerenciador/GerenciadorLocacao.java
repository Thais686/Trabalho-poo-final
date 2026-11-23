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

public void cadastrar(Locacao l1) {

     if (l1.getEquipamentos().isEmpty()) {
        throw new IllegalArgumentException("A locação precisa ter pelo menos um equipamento!");
    }

    locacoes.add(l1);
 }

public void mostrarHistorico() {

        for (Locacao l : locacoes) {

            System.out.println("Cliente: " + l.getCliente().getNome());
            System.out.println("Quantidade de dias: " + l.getQntdDias());

            System.out.println("Equipamentos:");

            for (Equipamento e : l.getEquipamentos()) {
               System.out.println("Código: " + e.getCodigo() + " | Descrição: " + e.getDescricao());
            }

            System.out.println("Valor total: R$ " + l.calcularTotal());

        }
    }

    public void listarLocacoesAtivas() {

    for (Locacao l : locacoes) {

        if (!l.getFinalizado()) {
            System.out.println("Cliente: " + l.getCliente().getNome());
            System.out.println("Dias: " + l.getQntdDias());
            for (Equipamento e : l.getEquipamentos()) {
                    System.out.println("Equipamento: " + e.getDescricao());
                }
        }
    }
         }

     public void consultarHistorico(Cliente cliente) {

        for (Locacao l : locacoes) {

            if (l.getCliente().getId() == cliente.getId()) {

                System.out.println("Quantidade de dias: " + l.getQntdDias());

                for (Equipamento e : l.getEquipamentos()) {
                    System.out.println("Equipamento: " + e.getDescricao());
                }

                System.out.println("Valor total: R$ " + l.calcularTotal());
            }
        }
    }

public void exibirDetalhes(Locacao l) {

    System.out.println("Cliente: " + l.getCliente().getNome());
    System.out.println("Quantidade de dias: " + l.getQntdDias());

    System.out.println("Equipamentos:");

    for (Equipamento e : l.getEquipamentos()) {

        System.out.println("Equipamento: " + e.getCodigo());

        System.out.println("Valor: R$ " + l.calcularValorEquipamento(e));
    }

    System.out.println("Valor total: R$ " + l.calcularTotal());
}
    
    
}
