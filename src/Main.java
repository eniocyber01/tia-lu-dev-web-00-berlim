import classes.Cliente;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n---- Sistema de Pedidos ----");
            System.out.println("1 - Menu Cliente");
            System.out.println("2 - Menu Item do Cardápio");
            System.out.println("3 - Menu Pedido");
            System.out.println("4 - Menu Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.print(opcao);

            switch (opcao) {
                case 1:
                    Cliente cliente1 = new Cliente(1,"Renatinha", "40028922");
                    System.out.print(cliente1.getNome());
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcao != 0);

        sc.close();
    }
}