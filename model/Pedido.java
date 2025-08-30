package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    public enum StatusPedido {
        EM_ANALISE,ACEITO, PREPARANDO, FEITO, AGUARDANDO_ENTREGADOR, SAIU_PARA_ENTREGA, ENTREGUE
    }

    private static int proximoNumero = 1;
    private int numero;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        this.numero = proximoNumero++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = StatusPedido.EM_ANALISE;
        LocalDateTime.now();
    }

    public boolean adicionarItem(ItemCardapio item, int quantidade) {
        if (item != null && quantidade > 0) {
            this.itens.add(new ItemPedido(item, quantidade));
            return true;
        }
        return false;
    }

    public boolean avancarStatus() {
        // Lógica de transição de status
        switch (this.status) {
            case EM_ANALISE:
                this.status = StatusPedido.ACEITO;
                return true;
            case ACEITO:
                this.status = StatusPedido.PREPARANDO;
                return true;
            case PREPARANDO:
                this.status = StatusPedido.FEITO;
                return true;
            case FEITO:
                this.status = StatusPedido.AGUARDANDO_ENTREGADOR;
                return true;
            case AGUARDANDO_ENTREGADOR:
                this.status = StatusPedido.SAIU_PARA_ENTREGA;
                return true;
            case SAIU_PARA_ENTREGA:
                this.status = StatusPedido.ENTREGUE;
                return true;
            default:
                return false;
        }
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public double getValorTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }
}