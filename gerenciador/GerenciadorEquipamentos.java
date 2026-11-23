package gerenciador;
import java.util.ArrayList;
import modelo.Equipamento;
import excecoes.EquipamentoNaoEncontradoException;

public class GerenciadorEquipamentos {

    private ArrayList<Equipamento> equipamentos;

    public GerenciadorEquipamentos() {

        equipamentos = new ArrayList<Equipamento>();

    }

    public void cadastrar(Equipamento e1) {
    for (Equipamento e : equipamentos) {
        if (e.getCodigo() == e1.getCodigo()) {
            throw new IllegalArgumentException("Já existe um equipamento com esse código!");
        }
    }

    equipamentos.add(e1);
}

     public void listar() {

        for (Equipamento e1 : equipamentos) {

            System.out.println( "ID: " + e1.getCodigo() + "   Descrição: " + e1.getDescricao() + "  Valor diária: R$ " + e1.getValorDiaria() + "  " + e1.exibirCaracteristicas());
        }
    }

    public void consultar(int codigo) throws EquipamentoNaoEncontradoException {

        for (Equipamento e1 : equipamentos) {
            if (e1.getCodigo() == codigo) {
                System.out.println( "ID: " + e1.getCodigo() + "  Descrição: " + e1.getDescricao() + "  Valor diária: R$ " + e1.getValorDiaria() + "   " + e1.exibirCaracteristicas() );
                return;
            }
        }
        throw new EquipamentoNaoEncontradoException(codigo);
    }

    public void listarDisponiveis() {

        for (Equipamento e1 : equipamentos) {

            if (e1.isDisponivel()) {

                 System.out.println( "ID: " + e1.getCodigo() + "  Descrição: " + e1.getDescricao() + "  Valor diária: R$ " + e1.getValorDiaria() + "  " + e1.exibirCaracteristicas() );
            }

        }
    }
}