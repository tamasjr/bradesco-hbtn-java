import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {
    private String nome;
    private double preco;
    private double percentualMarkup = 10.0;

    public Produto(double preco, String nome) {
        this.nome = nome;
        this.preco = preco;
    }

    public Supplier<Double> precoComMarkup = () -> preco * (1 + percentualMarkup / 100);

    public Consumer<Double> atualizarMarkup = novoMarkup -> this.percentualMarkup = novoMarkup;

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getPercentualMarkup() {
        return percentualMarkup;
    }
}
