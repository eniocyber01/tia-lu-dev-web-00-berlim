package classes;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    // Enum para status do pedido
    public enum Status {
        ACEITO, PREPARANDO, FEITO, AGUARDANDO_ENTREGADOR, SAIU_PARA_ENTREGA, ENTREGUE
    }

    // Atributos do Pedido
    private int numero;
    private Status status;
    private Cliente cliente;

    public Pedido(int numero, Cliente cliente){
        this.numero = numero;
        this.cliente = cliente;
        this.status = Status.ACEITO; // Pedido já inicia com status ACEITO
    }
    public int getNumero(){
        return numero;
    }
    public Status getStatus(){
        return status;
    }
    public Cliente getCliente(){
        return cliente;
    } 
}