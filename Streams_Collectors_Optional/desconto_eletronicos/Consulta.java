import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Map;

public class Consulta {
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos().stream()
                .filter(p -> p.getCategoria() == CategoriaProduto.LIVRO)
                .collect(Collectors.toList());
    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .findFirst()
                .orElse(null);
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream()
                .filter(p -> p.getPreco() >= precoMinimo)
                .collect(Collectors.toList());
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream()
                .filter(p -> p.getProdutos().stream()
                        .anyMatch(produto -> produto.getCategoria() == CategoriaProduto.ELETRONICO))
                .collect(Collectors.toList());
    }

    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        return produtos.stream()
                .map(produto -> {
                    if (produto.getCategoria() == CategoriaProduto.ELETRONICO) {
                        return new Produto(
                                produto.getCodigo(),
                                produto.getNome(),
                                produto.getCategoria(),
                                produto.getPreco() * 0.85
                        );
                    } else {
                        return produto;
                    }
                })
                .collect(Collectors.toList());
    }
}
