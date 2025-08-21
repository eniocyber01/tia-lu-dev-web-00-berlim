package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    // Enum para status do pedido
    public enum Status {
        ACEITO, PREPARANDO, FEITO, AGUARDANDO_ENTREGADOR, SAIU_PARA_ENTREGA, ENTREGUE
    }

    // Atributos
    private int numero;
    private Status status;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Date dataHora;

    // Construtor
    public Pedido(int numero, Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        this.numero = numero;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = Status.ACEITO;
        this.dataHora = new Date();
    }

    // Métodos
    public void adicionarItem(ItemCardapio item, int quantidade) {
        if (item != null && quantidade > 0) {
            itens.add(new ItemPedido(item, quantidade));
        }
    }

    public boolean atualizarStatus() {
        Status proximoStatus = getProximoStatus();
        if (proximoStatus != null) {
            status = proximoStatus;
            notificarMudancaStatus();
            return true;
        }
        return false;
    }

    private Status getProximoStatus() {
        switch (status) {
            case ACEITO: return Status.PREPARANDO;
            case PREPARANDO: return Status.FEITO;
            case FEITO: return Status.AGUARDANDO_ENTREGADOR;
            case AGUARDANDO_ENTREGADOR: return Status.SAIU_PARA_ENTREGA;
            case SAIU_PARA_ENTREGA: return Status.ENTREGUE;
            default: return null;
        }
    }

    private void notificarMudancaStatus() {
        // Para futura extensibilidade (ex.: log ou notificação)
        System.out.println("Status do pedido " + numero + " alterado para " + status);
    }

    public double getValorTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }

    public Status getStatus() {
        return status;
    }

    public Date getDataHora() {
        return dataHora;
    }
}
