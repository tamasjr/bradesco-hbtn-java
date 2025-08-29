import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes = 0;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        quantidadeTransacoes++;
        // Discount transaction fee
        try {
            java.lang.reflect.Field saldoField = ContaBancariaBasica.class.getDeclaredField("saldo");
            saldoField.setAccessible(true);
            saldoField.set(this, getSaldo() - 0.10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        quantidadeTransacoes++;
        // Discount transaction fee
        try {
            java.lang.reflect.Field saldoField = ContaBancariaBasica.class.getDeclaredField("saldo");
            saldoField.setAccessible(true);
            saldoField.set(this, getSaldo() - 0.10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }
}