package classes;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    

    public Cliente(int id, String nome, String telefone) {
        if (nome == null){
            throw new IllegalArgumentException("Nomes não pode ser nulo!"); // interrompe o programa, caso o cliente seja nulo!
        }
        if (telefone == null){
            throw new IllegalArgumentException("Telefone não pode ser nulo!");// interrompe o programa, caso o cliente seja nulo!
        }
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() { return nome; }
}
