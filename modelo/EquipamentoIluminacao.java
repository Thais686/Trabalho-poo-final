package modelo;

public class EquipamentoIluminacao extends Equipamento {

    public enum TipoIluminacao {
        LED("LED"), REFLETOR("Refletor"), LASER("Laser");

        private String descricao;

        TipoIluminacao(String descricao) {
            this.descricao = descricao;
        }

        @Override
        public String toString() {
            return descricao;
        }
    }

    private TipoIluminacao tipo;
    private double potencia;

    public EquipamentoIluminacao(int codigo, String descricao, double valorDiaria, TipoIluminacao tipo, double potencia){
        super(codigo, descricao, valorDiaria);
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public TipoIluminacao getTipo() {
        return tipo;
    }

    public double getPotencia() {
        return potencia;
    }

    @Override
    public double calcularValor(int dias){
        double valor = getValorDiaria() * dias;
        return valor + (valor * 0.10);
    }

    @Override
    public String exibirCaracteristicas() {
        return "Tipo: " + tipo + " | Potência: " + potencia + " watts";
    }
}
