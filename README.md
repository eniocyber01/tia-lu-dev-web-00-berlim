# tia-lu-dev-web-00-berlim

Sistema de gerenciamento de pedidos para delivery, feito em Java (linha de comando).

## Como rodar

1. Compile todos os arquivos Java do diretório `model`:
   ```sh
   javac model/*.java
   ```

1. Executar o programa:
   ```sh
   java model.SistemaPedidosCLI
   ```
   
## Funcionalidades
* **Gerenciamento de Cardápio**
    * Cadastrar novo item
    * Listar itens do cardápio
* **Gerenciamento de Clientes**
    * Cadastrar novo cliente
    * Listar clientes
* **Gerenciamento de Pedidos**
    * Registrar novo pedido (escolher cliente, adicionar itens)
    * Atualizar status do pedido (avançar etapas)
    * Consultar pedidos por status
* **Relatórios**
    * Relatório de vendas simplificado (total de pedidos e valor arrecadado)
    * Relatório de vendas detalhado (detalhes de cada pedido)

## Requisitos:

* Java 8 ou superior

## Documentação

Na pasta `docs/` você encontra:

- **apresentacao_berlim.pdf**: Apresentação do projeto.
- **relatorio_tecnico_berlim.pdf**: Relatório técnico detalhado sobre o sistema.

Esses arquivos ajudam a entender o funcionamento, requisitos e detalhes do projeto.
