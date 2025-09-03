public class Pedido {
    private java.util.List<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new java.util.ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedido) {
        cookies.add(pedido);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie pedido : cookies) {
            total += pedido.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int quantidadeRemovida = 0;
        java.util.Iterator<PedidoCookie> iterator = cookies.iterator();
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