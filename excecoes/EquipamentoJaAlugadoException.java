package excecoes;

public class EquipamentoJaAlugadoException extends Exception {
    public EquipamentoJaAlugadoException(int codigo) {

    super("O equipamento de código " + codigo + " já está alugado!");
    
}}