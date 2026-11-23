package excecoes;

public class EquipamentoJaEstaNaSuaLocacaoException extends Exception {
    public EquipamentoJaEstaNaSuaLocacaoException(int codigo) {

        super("O equipamento de código " + codigo + " já está nesta locação!");
    }
}