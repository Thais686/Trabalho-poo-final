package modelo;

public class EquipamentoSom extends Equipamento {

    private int potencia;
    private int qtdCanais;

    public EquipamentoSom(int codigo, String descricao, double valorDiaria, int potencia,int qtdCanais) {

        super(codigo, descricao, valorDiaria);

        this.potencia = potencia;
        this.qtdCanais = qtdCanais;
    }

    public int getPotencia() {
    return potencia;
}

public int getQtdCanais() {
    return qtdCanais;
}

@Override
public double calcularValor(int dias) {
        return getValorDiaria() * dias;
}

@Override
public String exibirCaracteristicas() {
    return "Potência: " + potencia + " watts  Canais: " + qtdCanais;
}
}