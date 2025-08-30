package model;
import java.util.Scanner;

public class SistemaPedidosCLI {

    private static CentralDeDados central = CentralDeDados.getInstancia();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    public static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n--- Lu Delivery - Menu Principal ---");
            System.out.println("1. Gerenciamento de Cardápio");
            System.out.println("2. Gerenciamento de Clientes");
            System.out.println("3. Gerenciamento de Pedidos");
            System.out.println("4. Relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciarCardapio();
                    break;
                case 2:
                    gerenciarClientes();
                    break;
                case 3:
                    gerenciarPedidos();
                    break;
                case 4:
                    gerarRelatorios();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    // Métodos para Gerenciamento de Cardápio
    public static void gerenciarCardapio() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciamento de Cardápio ---");
            System.out.println("1. Cadastrar Novo Item");
            System.out.println("2. Listar Itens");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarNovoItem();
                    break;
                case 2:
                    listarItensCardapio();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
    
    public static void cadastrarNovoItem() {
        System.out.println("\n--- Cadastrar Novo Item ---");
        String nome = "";
        double preco = -1;

        // Validação do nome
        while (nome.trim().isEmpty()) {
            System.out.print("Nome do item: ");
            nome = scanner.nextLine();
            if (nome.trim().isEmpty()) {
                System.out.println("O nome não pode ser vazio. Por favor, tente novamente.");
            }
        }

        // Validação do preço
        while (preco <= 0) {
            System.out.print("Preço do item: ");
            if (scanner.hasNextDouble()) {
                preco = scanner.nextDouble();
                if (preco <= 0) {
                    System.out.println("O preço deve ser maior que zero. Por favor, tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Descarta a entrada inválida
            }
        }
        scanner.nextLine();

        ItemCardapio novoItem = new ItemCardapio(nome, preco);
        central.adicionarItemCardapio(novoItem);
        System.out.println("Item cadastrado com sucesso! Código: " + novoItem.getCodigo());
    }

    public static void listarItensCardapio() {
        System.out.println("\n--- Cardápio ---");
        if (central.getItensCardapio().isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            for (ItemCardapio item : central.getItensCardapio()) {
                System.out.println("Código: " + item.getCodigo() +
                                   ", Nome: " + item.getNome() +
                                   ", Preço: R$" + String.format("%.2f", item.getPreco()));
            }
        }
    }
    
    // Métodos para Gerenciamento de Clientes
    public static void gerenciarClientes() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciamento de Clientes ---");
            System.out.println("1. Cadastrar Novo Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarNovoCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void cadastrarNovoCliente() {
        System.out.println("\n--- Cadastrar Novo Cliente ---");
        String nome = "";
        String telefone = "";

        // Validação do nome
        while (nome.trim().isEmpty()) {
            System.out.print("Nome do cliente: ");
            nome = scanner.nextLine();
            if (nome.trim().isEmpty()) {
                System.out.println("O nome não pode ser vazio. Por favor, tente novamente.");
            }
        }

        // Validação do telefone
        while (telefone.trim().isEmpty()) {
            System.out.print("Telefone do cliente: ");
            telefone = scanner.nextLine();
            if (telefone.trim().isEmpty()) {
                System.out.println("O telefone não pode ser vazio. Por favor, tente novamente.");
            }
        }

        Cliente novoCliente = new Cliente(nome, telefone);
        central.adicionarCliente(novoCliente);
        System.out.println("Cliente cadastrado com sucesso! Código: " + novoCliente.getCodigo());
    }

    public static void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        if (central.getClientes().isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : central.getClientes()) {
                System.out.println("Código: " + cliente.getCodigo() +
                                   ", Nome: " + cliente.getNome() +
                                   ", Telefone: " + cliente.getTelefone());
            }
        }
    }
    
    // Métodos para Gerenciamento de Pedidos
    public static void gerenciarPedidos() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciamento de Pedidos ---");
            System.out.println("1. Registrar Novo Pedido");
            System.out.println("2. Atualizar Status do Pedido");
            System.out.println("3. Consultar Pedidos por Status");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    registrarNovoPedido();
                    break;
                case 2:
                    atualizarStatusPedido();
                    break;
                case 3:
                    consultarPedidosPorStatus();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void registrarNovoPedido() {
        System.out.println("\n--- Registrar Novo Pedido ---");
        
        if (central.getClientes().isEmpty()) {
            System.out.println("Não é possível registrar um pedido. Nenhum cliente cadastrado.");
            return;
        }

        if (central.getItensCardapio().isEmpty()) {
            System.out.println("Não é possível registrar um pedido. Nenhum item no cardápio.");
            return;
        }

        listarClientes();
        int codigoCliente;
        Cliente clienteSelecionado = null;
        
        // Validação do cliente
        do {
            System.out.print("Digite o código do cliente: ");
            if (scanner.hasNextInt()) {
                codigoCliente = scanner.nextInt();
                scanner.nextLine();
                for (Cliente c : central.getClientes()) {
                    if (c.getCodigo() == codigoCliente) {
                        clienteSelecionado = c;
                        break;
                    }
                }
                if (clienteSelecionado == null) {
                    System.out.println("Cliente não encontrado. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Descarta a entrada inválida
            }
        } while (clienteSelecionado == null);

        Pedido novoPedido = new Pedido(clienteSelecionado);
        
        int codigoItem;
        do {
            listarItensCardapio();
            System.out.print("Digite o código do item do cardápio para adicionar ao pedido (ou '0' para finalizar): ");
            if (scanner.hasNextInt()) {
                codigoItem = scanner.nextInt();
                scanner.nextLine();

                if (codigoItem == 0) {
                    if (novoPedido.getItens().isEmpty()) {
                        System.out.println("O pedido não pode ser finalizado sem itens. Adicione pelo menos um item.");
                        continue;
                    }
                    break;
                }

                ItemCardapio itemSelecionado = null;
                for (ItemCardapio i : central.getItensCardapio()) {
                    if (i.getCodigo() == codigoItem) {
                        itemSelecionado = i;
                        break;
                    }
                }

                if (itemSelecionado != null) {
                    int quantidade = 0;
                    // Validação da quantidade
                    while (quantidade <= 0) {
                        System.out.print("Digite a quantidade: ");
                        if (scanner.hasNextInt()) {
                            quantidade = scanner.nextInt();
                            scanner.nextLine();
                            if (quantidade <= 0) {
                                System.out.println("A quantidade deve ser maior que zero. Tente novamente.");
                            }
                        } else {
                            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                            scanner.next(); // Descarta a entrada inválida
                        }
                    }
                    novoPedido.adicionarItem(itemSelecionado, quantidade);
                    System.out.println("Item adicionado ao pedido.");
                } else {
                    System.out.println("Item do cardápio não encontrado.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next(); // Descarta a entrada inválida
            }
        } while (true);

        central.adicionarPedido(novoPedido);
        System.out.println("Pedido " + novoPedido.getNumero() + " registrado com sucesso para o cliente " + clienteSelecionado.getNome() + ".");
        System.out.println("Status inicial: " + novoPedido.getStatus());
    }

    public static void atualizarStatusPedido() {
        System.out.println("\n--- Atualizar Status do Pedido ---");
        System.out.print("Digite o número do pedido: ");
        int numeroPedido = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = null;
        for (Pedido p : central.getPedidos()) {
            if (p.getNumero() == numeroPedido) {
                pedido = p;
                break;
            }
        }

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }
        
        System.out.println("Status atual do pedido " + pedido.getNumero() + ": " + pedido.getStatus());
        if (pedido.avancarStatus()) {
            System.out.println("Status atualizado com sucesso para: " + pedido.getStatus());
        } else {
            System.out.println("Não foi possível avançar o status do pedido. Ele já está no estado final ou uma transição inválida foi tentada.");
        }
    }
    
    public static void consultarPedidosPorStatus() {
        System.out.println("\n--- Consultar Pedidos por Status ---");
        System.out.println("Status disponíveis: ACEITO, PREPARANDO, FEITO, AGUARDANDO_ENTREGADOR, SAIU_PARA_ENTREGA, ENTREGUE");
        System.out.print("Digite o status para consulta: ");
        String statusInput = scanner.nextLine().toUpperCase();

        try {
            Pedido.StatusPedido status = Pedido.StatusPedido.valueOf(statusInput);
            System.out.println("\n--- Pedidos com status: " + status + " ---");
            boolean encontrou = false;
            for (Pedido p : central.getPedidos()) {
                if (p.getStatus() == status) {
                    System.out.println("Pedido #" + p.getNumero() + " para o cliente " + p.getCliente().getNome());
                    encontrou = true;
                }
            }
            if (!encontrou) {
                System.out.println("Nenhum pedido encontrado com este status.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Status inválido.");
        }
    }
    
    // Métodos para Relatórios
    public static void gerarRelatorios() {
        int opcao;
        do {
            System.out.println("\n--- Relatórios ---");
            System.out.println("1. Relatório de Vendas (Simplificado)");
            System.out.println("2. Relatório de Vendas (Detalhado)");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerarRelatorioVendasSimplificado();
                    break;
                case 2:
                    gerarRelatorioVendasDetalhado();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void gerarRelatorioVendasSimplificado() {
        System.out.println("\n--- Relatório de Vendas (Simplificado) ---");
        int totalPedidos = central.getPedidos().size();
        double valorTotalArrecadado = 0;
        for (Pedido pedido : central.getPedidos()) {
            valorTotalArrecadado += pedido.getValorTotal();
        }
        System.out.println("Quantidade total de pedidos: " + totalPedidos);
        System.out.println("Valor total arrecadado: R$" + String.format("%.2f", valorTotalArrecadado));
    }

    public static void gerarRelatorioVendasDetalhado() {
        System.out.println("\n--- Relatório de Vendas (Detalhado) ---");
        if (central.getPedidos().isEmpty()) {
            System.out.println("Nenhum pedido para gerar o relatório.");
            return;
        }

        for (Pedido pedido : central.getPedidos()) {
            System.out.println("\n----------------------------------------");
            System.out.println("Pedido #" + pedido.getNumero());
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("Itens do Pedido:");
            for (ItemPedido item : pedido.getItens()) {
                System.out.println(" - " + item.getQuantidade() + "x " + item.getItem().getNome() +
                                   " (R$" + String.format("%.2f", item.getItem().getPreco()) + ")");
            }
            System.out.println("Valor Total do Pedido: R$" + String.format("%.2f", pedido.getValorTotal()));
        }
        System.out.println("----------------------------------------");
    }
}