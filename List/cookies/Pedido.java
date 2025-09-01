public class Pedido {
    private java.util.List<PedidoCookie> pedidos = new java.util.ArrayList<>();

    public void adicionarPedidoCookie(PedidoCookie pedido) {
        pedidos.add(pedido);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie pedido : pedidos) {
            total += pedido.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int quantidadeRemovida = 0;
        java.util.Iterator<PedidoCookie> iterator = pedidos.iterator();
        while (iterator.hasNext()) {
            PedidoCookie pedido = iterator.next();
            if (pedido.getSabor().equalsIgnoreCase(sabor)) {
                quantidadeRemovida += pedido.getQuantidadeCaixas();
                iterator.remove();
            }
        }
        return quantidadeRemovida;
    }
}