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

     public String  listar() {

        String resultado= "";

        for (Equipamento e1 : equipamentos) {

            resultado += "ID: " + e1.getCodigo() + "   Descrição: " + e1.getDescricao() + "  Valor diária: R$ " + e1.getValorDiaria() + "  " + e1.exibirCaracteristicas() + "\n";
        }
        return resultado;
    }

    public String consultar(int codigo) throws EquipamentoNaoEncontradoException {

            String resultado="";

        for (Equipamento e1 : equipamentos) {
            if (e1.getCodigo() == codigo) {
                resultado += "ID: " + e1.getCodigo() + "\n";
                resultado += "Descrição: " + e1.getDescricao() + "\n";
                resultado += "Valor diária: R$ " + e1.getValorDiaria() + "\n";
                resultado += e1.exibirCaracteristicas() + "\n";
                return resultado;
            }
        }
        throw new EquipamentoNaoEncontradoException(codigo);
    }

    public String listarDisponiveis() {

        String resultado= "";

        for (Equipamento e1 : equipamentos) {

            if (e1.isDisponivel()) {

                 resultado += "ID: " + e1.getCodigo() + "\n";
                 resultado += "Descrição: " + e1.getDescricao() + "\n";
                 resultado += "Valor diária: R$ " + e1.getValorDiaria() + "\n";
                resultado += e1.exibirCaracteristicas() + "\n";
            }

        }
        return resultado;
    }

    public Equipamento buscarPorCodigo(int codigo) throws EquipamentoNaoEncontradoException {
    for (Equipamento e : equipamentos) {
        if (e.getCodigo() == codigo) {
            return e;
        }
    }

    throw new EquipamentoNaoEncontradoException(codigo);
}
}
