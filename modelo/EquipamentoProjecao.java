package modelo;

public class EquipamentoProjecao extends Equipamento {

    public enum Resolucao {
        HD("HD"), FULL_HD("Full HD"), UHD_4K("4K");

        private String descricao;

        Resolucao(String descricao) {
            this.descricao = descricao;
        }

        @Override
        public String toString() {
            return descricao;
        }
    }

    private Resolucao resolucao;
    private double luminosidade;

    public EquipamentoProjecao(int codigo, String descricao, double valorDiaria, Resolucao resolucao, double luminosidade){
        super(codigo, descricao, valorDiaria);
        this.resolucao = resolucao;
        this.luminosidade = luminosidade;
    }

    public Resolucao getResolucao() {
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
