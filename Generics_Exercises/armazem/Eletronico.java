public class Eletronico {
    private String descricao;
    private double preco;

    public Eletronico(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("[%s] R$ %f", descricao, preco);
    }
}
