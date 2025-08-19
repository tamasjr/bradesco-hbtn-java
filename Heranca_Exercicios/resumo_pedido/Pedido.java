public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }
        total -= total * (percentualDesconto / 100.0);
        return total;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0.0;
        for (ItemPedido item : itens) {
            String tipo = item.getProduto().getClass().getSimpleName();
            String titulo = item.getProduto().getTitulo();
            double preco = item.getProduto().obterPrecoLiquido();
            int quant = item.getQuantidade();
            double totalItem = preco * quant;
            totalProdutos += totalItem;
            System.out.println(String.format(
                    "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f",
                    tipo, titulo, preco, quant, totalItem
            ));
        }
        System.out.println("----------------------------");
        double desconto = totalProdutos * (percentualDesconto / 100.0);
        System.out.println(String.format("DESCONTO: %.2f", desconto));
        System.out.println(String.format("TOTAL PRODUTOS: %.2f", totalProdutos));
        System.out.println("----------------------------");
        System.out.println(String.format("TOTAL PEDIDO: %.2f", totalProdutos - desconto));
        System.out.println("----------------------------");
    }
}