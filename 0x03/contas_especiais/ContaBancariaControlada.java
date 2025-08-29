import exceptions.OperacaoInvalidaException;

public class ContaBancariaControlada extends ContaBancariaBasica {
    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual, double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        super.aplicarAtualizacaoMensal();
        if (getSaldo() < saldoMinimo) {
            // Directly update saldo using reflection of setter logic
            try {
                java.lang.reflect.Field saldoField = ContaBancariaBasica.class.getDeclaredField("saldo");
                saldoField.setAccessible(true);
                saldoField.set(this, getSaldo() - valorPenalidade);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}