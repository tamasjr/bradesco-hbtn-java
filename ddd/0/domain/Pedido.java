package domain;


import infrastructure.PedidoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Pedido {


    private final String id;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;
    private PedidoRepository pedidoRepository;


    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }


    public void adicionarProduto(Produto produto) {
        if (status == StatusPedido.PENDENTE) {
            produtos.add(produto);
        }
    }

    public void removerProduto(Produto produto) {
        if (status == StatusPedido.PENDENTE) {
            produtos.remove(produto);
        }
    }

    public void pagar() {
        if (status == StatusPedido.PENDENTE && !produtos.isEmpty()) {
            status = StatusPedido.PAGO;
        }
    }

    public void cancelar() {
        if (status == StatusPedido.PENDENTE) {
            status = StatusPedido.CANCELADO;
        }
    }


    public String getId() {
        return id;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public List<Produto> getProdutos() {
        return produtos;
    }


    public StatusPedido getStatus() {
        return status;
    }
}