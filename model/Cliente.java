package model;
public class Cliente {
    private static int proximoCodigo = 1;
    private int codigo;
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        this.codigo = proximoCodigo++;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}