package model;

import java.util.ArrayList;
import java.util.List;

public class CentralDeDados {
    private static CentralDeDados instancia;
    private List<Cliente> clientes;
    private List<ItemCardapio> itensCardapio;
    private List<Pedido> pedidos;

    private CentralDeDados() {
        this.clientes = new ArrayList<>();
        this.itensCardapio = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public static CentralDeDados getInstancia() {
        if (instancia == null) {
            instancia = new CentralDeDados();
        }
        return instancia;
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarItemCardapio(ItemCardapio item) {
        this.itensCardapio.add(item);
    }

    public List<ItemCardapio> getItensCardapio() {
        return itensCardapio;
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}