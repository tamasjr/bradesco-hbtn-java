import java.text.DecimalFormat;

public class Produto {
    private int codigo;
    private String nome;
    private CategoriaProduto categoria;
    private double preco;

    public Produto(int codigo, String nome, CategoriaProduto categoria, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "[" + codigo + "] " + nome + " " + categoria + " R$ " + df.format(preco);
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }
}
