package modelo;

public class EquipamentoProjecao extends Equipamento{
    private String resolucao;
    private double luminosidade;
    

    public EquipamentoProjecao(int codigo, String descricao, double valorDiaria, String resolucao, double luminosidade){
        super(codigo,descricao, valorDiaria);
        this.resolucao = resolucao;
        this.luminosidade = luminosidade;
    }

    public String getResolucao() {
    return resolucao;
}

public double getLuminosidade() {
    return luminosidade;
}

    
@Override
public double calcularValor(int dias){

    double valor = (getValorDiaria() * dias);
        if (dias >= 5){
        valor = valor - (valor * 0.10);
    }
        return valor;
    }

@Override
public String exibirCaracteristicas() {
    return "Resolução: " + resolucao + "  Luminosidade: " + luminosidade + " lúmens";
}
}
